package com.cebbank.shopper_consumer.service;

public interface MqService {
    /**
     * 用户购物车下单，通知商家
     * */
    void notifySellerOrder(Object msg);
}
