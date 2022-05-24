package com.letscode.ecproductsapi.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "products")
@Getter
@Setter
public class ProductEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String group;
    private String description;
    private Long supply;
    private BigDecimal price;

    public ProductEntity(String name, String group, String description, Long supply, BigDecimal price) {
        this.name = name;
        this.group = group;
        this.description = description;
        this.supply = supply;
        this.price = price;
    }
}
