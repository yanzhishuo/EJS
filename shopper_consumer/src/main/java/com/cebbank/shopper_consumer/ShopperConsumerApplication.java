package com.cebbank.shopper_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ShopperConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopperConsumerApplication.class, args);
    }

}
