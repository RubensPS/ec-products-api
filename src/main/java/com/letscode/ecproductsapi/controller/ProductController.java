package com.letscode.ecproductsapi.controller;

import com.letscode.ecproductsapi.domain.ProductRequest;
import com.letscode.ecproductsapi.domain.ProductResponse;
import com.letscode.ecproductsapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ProductResponse> addNewProduct(@RequestBody ProductRequest request) {
        return productService.addProduct(request);
    }

    @GetMapping("/get/price/{productId}")
    public ResponseEntity<BigDecimal> getPriceByProductId(@PathVariable String productId) {
        BigDecimal productPrice = productService.getPriceById(productId);
        return ResponseEntity.ok(productPrice);
    }

    @GetMapping("/get/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String productId) {
        ProductResponse response = productService.getProduct(productId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable String productId) {
        return productService.deleteProduct(productId);
    }

    @GetMapping("/supply/{cartId}")
    public ResponseEntity<Boolean> checkCartSupply(@PathVariable String cartId) {
        return productService.checkSupply(cartId);
    }

    @PatchMapping("/supply/products")
    public ResponseEntity<String> subtractSupplyfromSale(@RequestBody HashMap<String, Long> products) {
        return productService.subtractSupply(products);
    }

}
