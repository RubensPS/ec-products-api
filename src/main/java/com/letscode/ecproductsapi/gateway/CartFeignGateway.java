package com.letscode.ecproductsapi.gateway;

import com.letscode.ecproductsapi.domain.ProductCartEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ec-carts-service")
public interface CartFeignGateway {

    @GetMapping("/carts/cart/{cartId}")
    ResponseEntity<ProductCartEntity> getCart(@PathVariable String cartId);

}
