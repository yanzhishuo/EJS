package com.cebbank.order_manage_provider;

import com.cebbank.order_manage_provider.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class OrderManageProviderApplicationTests {

    @Autowired
    OrderMapper orderMapper;
    @Test
    void contextLoads() {
    }

}
