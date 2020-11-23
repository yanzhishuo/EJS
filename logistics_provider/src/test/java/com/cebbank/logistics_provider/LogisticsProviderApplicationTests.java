package com.cebbank.logistics_provider;

import com.alibaba.druid.pool.DruidDataSource;
import com.cebbank.logistics_provider.mapper.LogisticEmpLoginMapper;
import com.cebbank.logistics_provider.mapper.LogisticsMapper;

import com.cebbank.logistics_provider.pojo.LogisticEmpLogin;
import com.cebbank.logistics_provider.service.LogisticEmpLoginService;
import com.cebbank.logistics_provider.service.LogisticsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
class LogisticsProviderApplicationTests {


//
//    @Test
//    void contextLoads() {
//
//        System.out.println(logisticsService.queryLogisticsByLogisticsId(1));
//    }

    //    @Autowired
//    LogisticsService logisticsService;
//    @Autowired
//    LogisticsService logisticsService;
//    @Test
//    public void aatest(){
//      logisticsService.LogisticsFinishedArrivedByLogisticsId(1);
//    }

    @Autowired
    LogisticEmpLoginService logisticEmpLoginService;
    @Test
    public void test1(){
        boolean x =logisticEmpLoginService.findUserByPhone("13522375371");
        System.out.println(x);
    }

    @Test
    public void test2(){
        LogisticEmpLogin user = new LogisticEmpLogin();
        user.setLogisticEmpLoginPassword("123456");
        user.setLogisticEmpLoginPhone("13522375371");
        boolean x =logisticEmpLoginService.findUserByPhoneAndPassword(user);
        System.out.println(x);
    }
    @Autowired
    LogisticEmpLoginMapper logisticEmpLoginMapper;
    @Test
    public void test(){
        LogisticEmpLogin userByPhone = logisticEmpLoginMapper.findUserByPhone("13522375371");
        System.out.println(userByPhone);
    }

    @Test
    public void test5(){
        boolean x =logisticEmpLoginService.findUserByPhone("13522375371");
        System.out.println(x);
    }


}
