package com.cebbank.shopper_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShopperProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopperProviderApplication.class, args);
    }

}
