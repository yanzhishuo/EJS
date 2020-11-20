package com.cebbank.management_mms_product_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ManagementMmsProductProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementMmsProductProviderApplication.class, args);
    }

}
