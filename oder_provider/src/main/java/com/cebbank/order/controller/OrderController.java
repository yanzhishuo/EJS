package com.cebbank.order.controller;

import com.cebbank.order.common.pojo.Order;
import com.cebbank.order.mapper.OrderMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @author yanzhishuo
 * @create 2020-11-16-15:13
 */
@RestController
public class OrderController {
    @Autowired(required = false)
    OrderMapper orderMapper;
    @RequestMapping(value = {"/userorder/placeorder"})
    public String placeorder(){
        System.out.println("显示下单界面");
        return "/placeorder" ;
    }
    @RequestMapping(value = {"/userorder/pay"})
    public int pay(@RequestParam(value ="orderId") Integer orderId, @RequestParam(value ="orderStatus") Integer orderStatus){
        System.out.println(orderId);
        System.out.println(orderStatus);
        int num = orderMapper.updateOrderstatusByOrderId(orderId, orderStatus);
        System.out.println(num);
        return num;
    }
    @RequestMapping(value = {"/userorder/orders"})
    public List<Map<String,Object>> orders(HttpServletResponse resp, @RequestParam(value ="userLoginId") Integer userLoginId) throws IOException {
        List<Map<String,Object>> orders = orderMapper.selectOrdersByUserLoginId(userLoginId);
        return orders;
    }

}
