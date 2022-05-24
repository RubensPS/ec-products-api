package com.letscode.ecproductsapi.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductResponse {
    private String id;
    private String name;
    private String group;
    private String description;
    private Long supply;
    private BigDecimal price;

    public ProductResponse(ProductEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.group = entity.getGroup();
        this.description = entity.getDescription();
        this.supply = entity.getSupply();
        this.price = entity.getPrice();
    }

}
