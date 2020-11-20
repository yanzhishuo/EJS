package com.cebbank.order_consumer.controller;

import com.cebbank.order_consumer.common.pojo.Order;
import com.cebbank.order_consumer.service.OrderService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author yanzhishuo
 * @create 2020-11-16-15:13
 */
@Controller

public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = {"/userorder/placeorder"})
    public String placeorder(){
        System.out.println("显示下单界面");
        return "/placeorder" ;
    }
    @RequestMapping(value = {"/userorder/pay"})
    public String pay(){
        System.out.println("显示支付界面");
        return "/pay" ;
    }
//    @RequestMapping(value = {"/userorder/orders"})
////    @ResponseBody
//    public String orders(HttpServletResponse resp,Model model) throws IOException {
//        List<Map<String,Object>> orders = orderService.findOrdersByUserLoginId(1);
//        System.out.println("显示用户订单界面");
//        System.out.println(orders);
//
////        resp.setContentType("application/json;charset=utf-8");
////        Gson gson = new Gson();
////        String s = gson.toJson(orders);
////        PrintWriter out = resp.getWriter();
////        out.println(s);
////        out.close();
//        return "orders";
//    }
//    @RequestMapping(value = {"/userorder/orders"})
////    @ResponseBody
//    public String orders(HttpServletResponse resp,Model model) throws IOException {
//        List<Map<String,Object>> orders = orderService.findOrdersByUserLoginId(1);
//        System.out.println("显示用户订单界面");
//        System.out.println(orders);
//        model.addAttribute("orders", orders);
//        return "orders";
//    }
    @RequestMapping("/userorder")
    public String queryAllOrder(Model model){
        return "orders";
    }


    @ResponseBody
    @RequestMapping("/userorder/order/list")
    public void orderList(HttpServletResponse resp) throws IOException {
        List<Map<String,Object>> orders = orderService.findOrdersByUserLoginId(1);
        System.out.println("显示用户订单界面");
        System.out.println(orders);

        resp.setContentType("application/json;charset=utf-8");
        Gson gson = new Gson();
        String s = gson.toJson(orders);
        PrintWriter out = resp.getWriter();
        System.out.println(s);
        out.println(s);
        out.close();
    }

    @ResponseBody
    @RequestMapping("/userorder/order/dilvery")
    public void dilveryOrders(HttpServletRequest request,HttpServletResponse resp ) throws IOException {
        System.out.println("修改状态");
        Integer orderId=Integer.parseInt(request.getParameter("orderId"));
        Integer orderStatus=Integer.parseInt(request.getParameter("orderstatus"));
        System.out.println(orderId);
        System.out.println(orderStatus);
        orderService.modifyOrderstatusByOrderId(orderId, orderStatus);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date= new Date();
        String date0 =sdf.format(date);
        System.out.println(date.toString());
        Order order = new Order();
        order.setOrderUpdateTime(date0);
        order.setOrderStatus(orderStatus);
        List<Map<String, Object>> ordersByUserLoginId = orderService.findOrdersByUserLoginId(1);
        resp.setContentType("application/json;charset=utf-8");
        Gson gson = new Gson();
        String s = gson.toJson(ordersByUserLoginId);
        PrintWriter out = resp.getWriter();
        System.out.println(s);
        out.println(s);
        out.close();
    }
}
