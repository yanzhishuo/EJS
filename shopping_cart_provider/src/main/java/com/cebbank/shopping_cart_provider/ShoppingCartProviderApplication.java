package com.cebbank.shopping_cart_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShoppingCartProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartProviderApplication.class, args);
    }

}
