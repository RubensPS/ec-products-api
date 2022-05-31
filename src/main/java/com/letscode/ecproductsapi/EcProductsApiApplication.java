package com.letscode.ecproductsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EcProductsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcProductsApiApplication.class, args);
    }

}
