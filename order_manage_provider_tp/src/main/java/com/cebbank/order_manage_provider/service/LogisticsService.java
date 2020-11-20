package com.cebbank.order_manage_provider.service;



import com.cebbank.order_manage_provider.pojo.Logistics;

import java.util.List;

public interface LogisticsService {
    /**
     * 根据id查询订单
     */
//    List<Order> queryOrderByOrderId(int OrderId);
    Logistics queryLogisticsByLogisticsId(Integer logistics_id);
    Integer LogisticsFinishedArrivedByLogisticsId(Integer logistics_id);
    List<Logistics> queryAllLogistics();
    Integer addLogistics(Logistics logistics);
}
