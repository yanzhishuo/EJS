package com.cebbank.management_mms_product_consumer.service;


import com.cebbank.management_mms_product_consumer.common.pojo.Logistics;
import com.cebbank.management_mms_product_consumer.common.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "service-ordermanage-provider")
@Component
public interface OrderService {
    /**
     *查询所有订单
     */
    @RequestMapping("/allorder")
    List<Order> queryAllOrder();
    /**
     *更新订单状态已送出
     */
    @RequestMapping("/delivery")
    Integer modifyOrderStatus1(Integer OrderId);
    /**
     *更新订单状态已送达
     */
    @RequestMapping("/confirmAccepted")
    Integer modifyOrderStatus2(Integer OrderId);
    /**
     *增加物流信息
     */
    @RequestMapping("/addlogistics")
    Integer addLogistics(Logistics logistics);
}
