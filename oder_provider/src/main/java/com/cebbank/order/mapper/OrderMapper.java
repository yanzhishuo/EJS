package com.cebbank.order.mapper;


import com.cebbank.order.common.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {
    /**
     * 功能：根据登录id查订单及详情，联合order及order_product
     * @param :登录用户的id
     */
    List<Map<String,Object>> selectOrdersByUserLoginId(Integer userLoginId);

    /**
     * 根据订单id更新订单状态
     * @param
     * @return
     */
    int updateOrderstatusByOrderId(@Param("orderId") Integer orderId,@Param("orderStatus") Integer orderStatus);
    /**
     * 根据订单编号更新订单状态
     * @param
     * @return
     */
    int updateOrderstatusByOrderUuid(@Param("orderUuid") String orderUuid,@Param("orderStatus") Integer orderStatus);


}
