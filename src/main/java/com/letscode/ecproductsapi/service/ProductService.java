package com.letscode.ecproductsapi.service;

import com.letscode.ecproductsapi.domain.ProductEntity;
import com.letscode.ecproductsapi.domain.ProductRequest;
import com.letscode.ecproductsapi.domain.ProductResponse;
import com.letscode.ecproductsapi.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService (ProductRepository repository) {
        this.repository = repository;
    }

    public ProductResponse addProduct(ProductRequest request) {
        ProductEntity entity = request.toEntity();
        ProductResponse response = new ProductResponse(repository.save(entity));
        return response;
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
}
