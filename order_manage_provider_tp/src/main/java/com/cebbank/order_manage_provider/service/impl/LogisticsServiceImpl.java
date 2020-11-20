package com.cebbank.order_manage_provider.service.impl;

import com.cebbank.order_manage_provider.mapper.LogisticsMapper;
import com.cebbank.order_manage_provider.mapper.OrderMapper;
import com.cebbank.order_manage_provider.pojo.Logistics;
import com.cebbank.order_manage_provider.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogisticsServiceImpl  implements LogisticsService {
    @Autowired
    private LogisticsMapper logisticsMapper;
    @Override
    public Logistics queryLogisticsByLogisticsId(Integer logistics_id) {
        return logisticsMapper.selectLogisticsByLogisticsId(logistics_id);
    }

    @Override
    public Integer LogisticsFinishedArrivedByLogisticsId(Integer logistics_id) {
        return logisticsMapper.updatelogisticsByLogisticsId(logistics_id);
    }

    @Override
    public List<Logistics> queryAllLogistics() {
        return logisticsMapper.selectAllLogistics();
    }

    @Override
    public Integer addLogistics(Logistics logistics) {
        return logisticsMapper.insertLogistics(logistics);
    }
}
