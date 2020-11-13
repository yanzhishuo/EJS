package com.cebbank.user_login_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BuyerProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuyerProviderApplication.class, args);
    }

}
