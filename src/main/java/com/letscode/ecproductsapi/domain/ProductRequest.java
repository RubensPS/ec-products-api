package com.letscode.ecproductsapi.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private String group;
    private String description;
    private Long supply;
    private BigDecimal price;

    public ProductEntity toEntity() {
        return new ProductEntity(
                this.name,
                this.group,
                this.description,
                this.supply,
                this.price);
    }

}
