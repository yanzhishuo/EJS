package com.cebbank.logistics_provider.controller;

import com.cebbank.logistics_provider.pojo.Logistics;
import com.cebbank.logistics_provider.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogisticsController {
    @Autowired
    private LogisticsService logisticsService;

    @RequestMapping("/logistic")
    public Logistics logisticsList(@RequestBody Integer logistics_id) {

        System.out.println(logisticsService.queryLogisticsByLogisticsId(logistics_id));
        return logisticsService.queryLogisticsByLogisticsId(logistics_id);
    }
    @RequestMapping("/confirm")
    public Integer logisticsFinished(@RequestBody Integer logistics_id){
        System.out.println(logistics_id);
        return logisticsService.LogisticsFinishedArrivedByLogisticsId(logistics_id);
    }
    @RequestMapping("/queryall")
    public  List<Logistics> queryAllLogistics()
    {
        System.out.println(logisticsService.queryAllLogistics());
        return logisticsService.queryAllLogistics();
    }
}
