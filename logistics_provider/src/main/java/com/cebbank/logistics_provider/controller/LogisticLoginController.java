package com.cebbank.logistics_provider.controller;

import com.cebbank.logistics_provider.pojo.LogisticEmpLogin;
import com.cebbank.logistics_provider.service.LogisticEmpLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogisticLoginController {

    @Autowired
    LogisticEmpLoginService logisticEmpLoginService;

    @RequestMapping("/check")
    public boolean findUserByPhone(@RequestParam("phone") String phone){
        System.out.println(logisticEmpLoginService.findUserByPhone(phone));
        return logisticEmpLoginService.findUserByPhone(phone);
    }

    @RequestMapping("/save")
    public void save(@RequestBody LogisticEmpLogin user){
        logisticEmpLoginService.save(user);
    }

    @RequestMapping("/log")
    public boolean findUserByPhoneAndPassword(@RequestBody LogisticEmpLogin user){
        return logisticEmpLoginService.findUserByPhoneAndPassword(user);
    }
}
