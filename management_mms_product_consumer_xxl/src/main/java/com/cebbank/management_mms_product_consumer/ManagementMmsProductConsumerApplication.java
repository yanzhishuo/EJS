package com.cebbank.management_mms_product_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ManagementMmsProductConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementMmsProductConsumerApplication.class, args);
    }

}
