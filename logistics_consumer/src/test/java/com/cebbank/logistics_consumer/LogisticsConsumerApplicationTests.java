package com.cebbank.logistics_consumer;

import com.cebbank.logistics_consumer.pojo.LogisticEmpLogin;
import com.cebbank.logistics_consumer.pojo.Logistics;
import com.cebbank.logistics_consumer.service.LogisticsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LogisticsConsumerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    LogisticsService logisticsService;

    @Test
    public void test1(){
        boolean x =logisticsService.findUserByPhone("13522375371");
        System.out.println(x);
    }

    @Test
    public void test2(){
        LogisticEmpLogin user = new LogisticEmpLogin();
        user.setLogisticEmpLoginPassword("123456");
        user.setLogisticEmpLoginPhone("13522375371");
        boolean x =logisticsService.findUserByPhoneAndPassword(user);
        System.out.println(x);
    }



}
