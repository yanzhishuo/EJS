package com.cebbank.shopper_consumer.service;

import com.cebbank.common.pojo.OrderStatus;
import com.cebbank.common.pojo.UserShoppingCart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "service-order-provider")
@Component
public interface OrderService {
    /**
     * @return
     */
    @RequestMapping("/userorder/orders")
    public List<Map<String,Object>> findOrdersByUserLoginId(@RequestParam(value ="userLoginId") Integer userLoginId);

    @RequestMapping("/userorder/pay")
    public int modifyOrderstatusByOrderId(@RequestParam(value ="orderId") Integer orderId, @RequestParam(value ="orderStatus") Integer orderStatus);

    @RequestMapping("/userorder/placeorder")
     int modifyOrderstatusByOrderUuid(@RequestParam(value ="orderUuid") String orderUuid,@RequestParam(value ="orderStatus") Integer orderStatus);

    //lsf部分
    @RequestMapping(value = "/order/selectedCarts/{userLoginId}")
    List<UserShoppingCart> getSelectedCarts(@PathVariable("userLoginId") Integer userLoginId, @RequestBody List<Integer> cartIds);

    @RequestMapping(value = "/order/createOrder/{userLoginId}/{userAddrId}")
    OrderStatus createOrder(@PathVariable("userLoginId") Integer userLoginId,@PathVariable("userAddrId")Integer userAddrId, @RequestBody List<Integer> cartIds);

}
