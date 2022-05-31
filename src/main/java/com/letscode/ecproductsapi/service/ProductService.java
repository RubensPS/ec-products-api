package com.letscode.ecproductsapi.service;

import com.letscode.ecproductsapi.domain.ProductCartEntity;
import com.letscode.ecproductsapi.domain.ProductEntity;
import com.letscode.ecproductsapi.domain.ProductRequest;
import com.letscode.ecproductsapi.domain.ProductResponse;
import com.letscode.ecproductsapi.gateway.CartGateway;
import com.letscode.ecproductsapi.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final CartGateway cartGateway;

    public ProductService (ProductRepository repository, CartGateway cartGateway) {
        this.repository = repository;
        this.cartGateway = cartGateway;
    }

    public ResponseEntity<ProductResponse> addProduct(ProductRequest request) {
        Optional<ProductEntity> entityCheck = repository.findByName(request.getName());
        if (entityCheck.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        ProductEntity entity = request.toEntity();
        ProductResponse response = new ProductResponse(repository.save(entity));
        return ResponseEntity.ok(response);
    }

    public BigDecimal getPriceById(String id) {
        ProductEntity productEntity = repository.findById(id).orElseThrow();
        return productEntity.getPrice();
    }

    public ProductResponse getProduct(String productId) {
        ProductEntity productEntity = repository.findById(productId).orElseThrow();
        ProductResponse response = new ProductResponse(productEntity);
        return response;
    }

    public List<ProductResponse> getAllProducts() {
        return repository
                .findAll()
                .stream()
                .map(entity -> new ProductResponse(entity))
                .collect(Collectors.toList());
    }

    public ResponseEntity<String> deleteProduct(String productId) {
        Optional<ProductEntity> entity = repository.findById(productId);
        if (entity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(entity.get().getId());
        return ResponseEntity.ok("Product DELETE successfully.");
    }

    public ResponseEntity<Boolean> checkSupply(String cartId) {
        ProductCartEntity cartEntity = cartGateway.getCart(cartId).getBody();
        Set<String> products = cartEntity.getProducts().keySet();
        Boolean checkProduct = cartEntity.getProducts().size() == products.stream().map(p -> repository.findById(p).get().getSupply().compareTo(cartEntity.getProducts().get(p)) >= 0 ? true : false).filter(t -> t.equals(true)).toList().size();
        if(!checkProduct) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(checkProduct);
    }

}
