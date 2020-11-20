package com.cebbank.order.service.impl;

import com.cebbank.order.common.pojo.Order;
import com.cebbank.order.mapper.OrderMapper;
import com.cebbank.order.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author yanzhishuo
 * @create 2020-11-16-18:42
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    public List<Map<String,Object>> findOrdersByUserLoginId(Integer userLoginId){
        return orderMapper.selectOrdersByUserLoginId(userLoginId);
    }
    public int modifyOrderstatusByOrderId(@Param("orderId") Integer orderId, @Param("orderStatus") Integer orderStatus){
        return orderMapper.updateOrderstatusByOrderId(orderId,orderStatus);
    }
    public int modifyOrderstatusByOrderUuid(@Param("orderUuid") String orderUuid,@Param("orderStatus") Integer orderStatus){
        return orderMapper.updateOrderstatusByOrderUuid(orderUuid,orderStatus);
    }

}
