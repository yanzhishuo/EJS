package com.cebbank.logistics_provider.service.impl;

import com.cebbank.logistics_provider.mapper.LogisticsMapper;
import com.cebbank.logistics_provider.pojo.Logistics;
import com.cebbank.logistics_provider.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogisticsServiceImpl implements LogisticsService {
    @Autowired
    private LogisticsMapper logisticsMapper;

    @Override
    public Logistics queryLogisticsByLogisticsId(Integer logistics_id) {
//        System.out.println(logistics_uuid);
        return logisticsMapper.selectLogisticsByLogisticsId(logistics_id);
    }
//   @Override
//    public List<Order> queryOrderByOrderId(int OrderId){
//       return logisticsMapper.selectOrderByOrderId(OrderId);
//   }


    @Override
    public Integer LogisticsFinishedArrivedByLogisticsId(Integer logistics_id) {
        logisticsMapper.updatelogisticsStatusByLogisticsId(logistics_id);
        return  logisticsMapper.updatelogisticsUpdateTimeByLogisticsId(logistics_id);
    }

    @Override
    public List<Logistics> queryAllLogistics() {
        return logisticsMapper.selectAllLogistics();
    }

}
