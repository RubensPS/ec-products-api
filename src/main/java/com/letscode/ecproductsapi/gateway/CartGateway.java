package com.letscode.ecproductsapi.gateway;

import com.letscode.ecproductsapi.domain.ProductCartEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartGateway {

    private final CartFeignGateway cartFeignGateway;

    public ResponseEntity<ProductCartEntity> getCart(String cartId) {
        return cartFeignGateway.getCart(cartId);
    }
}
