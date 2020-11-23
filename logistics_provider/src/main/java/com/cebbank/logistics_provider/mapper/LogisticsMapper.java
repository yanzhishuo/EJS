package com.cebbank.logistics_provider.mapper;


import com.cebbank.logistics_provider.pojo.Logistics;
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
    Logistics selectLogisticsByLogisticsId(Integer logisticsId);
    /**
     * 更新订单状态
     */
    Integer updatelogisticsStatusByLogisticsId(Integer logisticsId);
    /**
     * 改变订单更新时间
     */
    Integer updatelogisticsUpdateTimeByLogisticsId(Integer logisticsId);
    /**
     * 查询所有订单
     */
    List<Logistics> selectAllLogistics();
}
