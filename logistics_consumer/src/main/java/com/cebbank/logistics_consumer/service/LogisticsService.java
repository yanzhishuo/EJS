package com.cebbank.logistics_consumer.service;

import com.cebbank.logistics_consumer.pojo.LogisticEmpLogin;
import com.cebbank.logistics_consumer.pojo.Logistics;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(value = "service-logistics-provider")
@Component
//@Service
public interface LogisticsService {
    /**
     * 查询物流信息
     */

    @RequestMapping("/logistic")
     Logistics logisticsList( Integer logistics_id);

    /**
     *
     * 确认订单送达
     */
    @RequestMapping("/confirm")
     Integer logisticsFinished(Integer logistics_id);

    /**
     * 查询所有订单
     *
     */
    @RequestMapping("/queryall")
   List<Logistics> queryAllLogistics();


    @RequestMapping("/save")
    void save(@RequestBody LogisticEmpLogin user);

    @RequestMapping("/log")
    boolean findUserByPhoneAndPassword(@RequestBody LogisticEmpLogin user);

    @RequestMapping("/check")
    boolean findUserByPhone(@RequestParam("phone") String phone);


}
