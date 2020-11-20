package com.cebbank.order;

import com.cebbank.order.common.pojo.Order;
import com.cebbank.order.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class OrderApplicationTests {
    @Autowired
    OrderMapper orderMapper;

    @Test
    void contextLoads() {
    }
    @Test
    void testMapper() {
        List<Map<String,Object>> order = orderMapper.selectOrdersByUserLoginId(1);
        System.out.println(order);
    }

}
