package com.cebbank.order_manage_provider.mapper;


import com.cebbank.order_manage_provider.pojo.Logistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogisticsMapper {
//    /**
//     *根据orderid查询
//     */
//    List<Order> selectOrderByOrderId(int OrderId);

    /**
     * 根据logisticsuuid查询
     */
    Logistics selectLogisticsByLogisticsId(Integer logistics_id);
    /**
     * 更新订单状态
     */
    Integer updatelogisticsByLogisticsId(Integer logistics_id);
    /**
     * 查询所有物流订单
     */
    List<Logistics> selectAllLogistics();
    /**
     *插入物流订单
     */
    Integer insertLogistics(Logistics logistics);
}
