package com.cebbank.order_manage_provider.service;

import com.cebbank.order_manage_provider.pojo.Order;

import java.util.List;

public interface OrderService {
    List<Order> queryUDOrder();
    List<Order> queryDOrder();
    Integer modifyOrderStatus1(Integer OrderId);
    Integer modifyOrderStatus2(Integer OrderId);
}
