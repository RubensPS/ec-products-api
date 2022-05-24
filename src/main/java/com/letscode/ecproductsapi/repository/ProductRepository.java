package com.letscode.ecproductsapi.repository;

import com.letscode.ecproductsapi.domain.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}
