package com.cebbank.order_manage_provider.service.impl;

import com.cebbank.order_manage_provider.mapper.OrderMapper;
import com.cebbank.order_manage_provider.pojo.Order;
import com.cebbank.order_manage_provider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> queryUDOrder() {
        return orderMapper.selectUDAllOrder();
    }

    @Override
    public List<Order> queryDOrder() {
        return orderMapper.selectDlOrder();
    }

    @Override
    public Integer modifyOrderStatus1(Integer OrderId) {
        orderMapper.updateOrderUpdateTime(OrderId);
        return orderMapper.updateOrderStatus1(OrderId);
    }

    @Override
    public Integer modifyOrderStatus2(Integer OrderId) {
        orderMapper.updateOrderUpdateTime(OrderId);
        return orderMapper.updateOrderStatus2(OrderId);
    }
}
