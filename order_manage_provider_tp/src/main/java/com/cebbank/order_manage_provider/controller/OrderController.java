package com.cebbank.order_manage_provider.controller;

import com.cebbank.order_manage_provider.pojo.Logistics;
import com.cebbank.order_manage_provider.pojo.Order;
import com.cebbank.order_manage_provider.service.LogisticsService;
import com.cebbank.order_manage_provider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private LogisticsService logisticsService;
    @Autowired
    private OrderService orderService;
    @RequestMapping("/allorder")
    public List<Order> queryAllOrder(){
        List<Order> orderList = orderService.queryDOrder();
        System.out.println(orderList);
        orderList.addAll(orderService.queryUDOrder());
        System.out.println(orderList);
        System.out.println("***********************************");
        return orderList;
    }
    @RequestMapping("/delivery")
    public Integer modifyOrderStatus1(@RequestBody Integer OrderId){
        return orderService.modifyOrderStatus1(OrderId);
    }
    @RequestMapping("/confirmArrived")
    public Integer modifyOrderStatus2(@RequestBody Integer OrderId){
        return orderService.modifyOrderStatus2(OrderId);
    }
    @RequestMapping("/addlogistics")
    public Integer addLogistics(@RequestBody Logistics logistics){
        return logisticsService.addLogistics(logistics);
    }
}
