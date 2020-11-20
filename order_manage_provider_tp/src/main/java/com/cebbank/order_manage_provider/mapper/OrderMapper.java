package com.cebbank.order_manage_provider.mapper;

import com.cebbank.order_manage_provider.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface OrderMapper {
    /**
     *查询已发货订单()
     */
    List<Order> selectDlOrder();
    /**
     *查询未发货订单()
     */
    List<Order> selectUDAllOrder();
    /**
     * 更改订单状态已发货
     */
    Integer updateOrderStatus1(Integer OrderId);
      /**
     * 更改订单状态待收货
     */
    Integer updateOrderStatus2(Integer OrderId);
    /**
     * 更改订单更新时间
     */
    Integer updateOrderUpdateTime(Integer OrderId);
}
