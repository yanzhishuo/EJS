package com.cebbank.order.service;

import com.cebbank.order.common.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface OrderService {
    List<Map<String,Object>> findOrdersByUserLoginId(Integer userLoginId);
    int modifyOrderstatusByOrderId(@Param("orderId") Integer orderId, @Param("orderStatus") Integer orderStatus);
    int modifyOrderstatusByOrderUuid(@Param("orderUuid") String orderUuid,@Param("orderStatus") Integer orderStatus);
}
