package com.cebbank.shopper_consumer.service.impl;

import com.cebbank.shopper_consumer.service.MqService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqServiceImpl implements MqService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void notifySellerOrder(Object msg)
    {
        String obstr=msg.toString();
        //队列名称orderQueue
        amqpTemplate.convertAndSend("orderQueue",obstr);
    }
}
