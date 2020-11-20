package com.cebbank.order_consumer.service;

import com.cebbank.order_consumer.common.pojo.Order;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "service-order-provider")
@Component
public interface OrderService {
    /**
     *
     * @return
     */
    @RequestMapping("/userorder/orders")
    public List<Map<String,Object>> findOrdersByUserLoginId(@RequestParam(value ="userLoginId") Integer userLoginId);

    @RequestMapping("/userorder/pay")
    public int modifyOrderstatusByOrderId(@RequestParam(value ="orderId") Integer orderId, @RequestParam(value ="orderStatus") Integer orderStatus);

    @RequestMapping("/userorder/placeorder")
     int modifyOrderstatusByOrderUuid(@RequestParam(value ="orderUuid") String orderUuid,@RequestParam(value ="orderStatus") Integer orderStatus);

}
