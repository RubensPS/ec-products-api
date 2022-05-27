package com.letscode.ecproductsapi.controller;

import com.letscode.ecproductsapi.domain.ProductRequest;
import com.letscode.ecproductsapi.domain.ProductResponse;
import com.letscode.ecproductsapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ProductResponse> addNewProduct(@RequestBody ProductRequest request) {
        ProductResponse response = productService.addProduct(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/price/{id}")
    public ResponseEntity<BigDecimal> getPriceByProductId(@PathVariable String id) {
        BigDecimal productPrice = productService.getPriceById(id);
        return ResponseEntity.ok(productPrice);
    }

}
