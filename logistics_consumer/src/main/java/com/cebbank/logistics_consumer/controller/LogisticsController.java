package com.cebbank.logistics_consumer.controller;

import com.cebbank.logistics_consumer.pojo.Logistics;
import com.cebbank.logistics_consumer.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/logistics")
public class LogisticsController {
    @Autowired
    private LogisticsService logisticsService;
    @RequestMapping("/")
    public String logisticsList(){
//        List<Logistics> logisticsList;
//        logisticsList=logisticsService.queryAllLogistics();
//        model.addAttribute("logisticsList",logisticsList);
        return "logisticsList";
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<Logistics> logisticsList2(){
        System.out.println("hhhhhhh");
        List<Logistics> logisticsList=logisticsService.queryAllLogistics();
        System.out.println(logisticsList);
        return logisticsList ;
    }
    @GetMapping("/finished")
    @ResponseBody
    public List<Logistics> confirmArrived(Integer logisticsId ){

//        Integer logisticsId=Integer.parseInt(request.getParameter("logistics_id"));
        logisticsService.logisticsFinished(logisticsId);
        return logisticsService.queryAllLogistics();
    }
}
