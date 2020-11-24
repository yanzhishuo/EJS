package com.cebbank.logistics_provider.service;


import com.cebbank.logistics_provider.pojo.Logistics;

import java.util.List;

public interface LogisticsService {
    /**
     * 根据id查询订单
     */
//    List<Order> queryOrderByOrderId(int OrderId);
    Logistics queryLogisticsByLogisticsId(Integer logistics_id);
    Integer LogisticsFinishedArrivedByLogisticsId(Integer logistics_id);
    List<Logistics> queryAllLogistics();
}
