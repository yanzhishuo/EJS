package com.cebbank.management_mms_product_consumer.service;

import com.cebbank.management_mms_product_consumer.common.pojo.ShopEmpLogin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-mms-product-provider")
@Service
public interface UserLoginService {
    @RequestMapping("/admin/login")
    ShopEmpLogin login(@RequestParam(value = "phone") String phone, @RequestParam(value = "password") String password);
}
