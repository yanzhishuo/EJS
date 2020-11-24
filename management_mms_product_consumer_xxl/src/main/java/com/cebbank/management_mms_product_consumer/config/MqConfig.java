package com.cebbank.management_mms_product_consumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {
    @Bean
    public Queue orderQueue()
    {
        return new Queue("orderQueue",true);
    }

    @Bean
    public Queue logisticsQueue(){
        return new Queue("logisticsQueue",true);
    }
}
