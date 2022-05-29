package com.letscode.ecproductsapi.repository;

import com.letscode.ecproductsapi.domain.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {
    Optional<ProductEntity> findByName(String name);
}
