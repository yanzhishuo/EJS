package com.cebbank.management_mms_product_consumer.controller;


import com.cebbank.management_mms_product_consumer.common.pojo.Logistics;
import com.cebbank.management_mms_product_consumer.common.pojo.Order;
import com.cebbank.management_mms_product_consumer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    /**
     *订单页显示
     */
    @RequestMapping("/")
    public String queryAllOrder(){

        return "/orderlist";
    }
    /**
     *更新订单时间和物流状态
     */
    @RequestMapping("/dilvery")
    @ResponseBody
    public List<Order> dilveryGoods(Integer orderId ){
//        Integer orderId=Integer.parseInt(request.getParameter("orderId"));
        orderService.modifyOrderStatus1(orderId);
        //新建物流对象
        Logistics logistics=new Logistics();
        //随机生成物流uuid
        UUID logisticsUuid=UUID.randomUUID();
        logistics.setLogisticsUuid(logisticsUuid.toString());
        //改变物流状态
        logistics.setLogisticsStatus(2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date= new Date();
        String date0 =sdf.format(date);
        System.out.println(date.toString());
        logistics.setLogisticsCreateTime(date0);
        logistics.setLogisticsUpdateTime(date0);
        logistics.setOrderId(orderId);
        System.out.println(logistics);
        orderService.addLogistics(logistics);

        return orderService.queryAllOrder();
        }
    /**
     *刷新表单内容
     */
    @ResponseBody
    @RequestMapping("/list")
    public List<Order> logisticsList2(){
        return orderService.queryAllOrder();
    }
}
