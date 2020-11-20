package com.cebbank.user_login_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserLoginConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserLoginConsumerApplication.class, args);
    }

}
