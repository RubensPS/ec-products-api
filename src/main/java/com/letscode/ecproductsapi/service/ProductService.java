package com.letscode.ecproductsapi.service;

import com.letscode.ecproductsapi.domain.ProductEntity;
import com.letscode.ecproductsapi.domain.ProductRequest;
import com.letscode.ecproductsapi.domain.ProductResponse;
import com.letscode.ecproductsapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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
}
