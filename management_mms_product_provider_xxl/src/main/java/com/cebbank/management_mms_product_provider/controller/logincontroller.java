package com.cebbank.management_mms_product_provider.controller;

import com.cebbank.management_mms_product_provider.common.pojo.ShopEmpLogin;
import com.cebbank.management_mms_product_provider.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanzhishuo
 * @create 2020-11-18-19:43
 */
@RestController
public class logincontroller {
    @Autowired
    UserLoginService userLoginService;

    @RequestMapping("/admin/login")
    public ShopEmpLogin login(@RequestParam(value = "phone") String phone, @RequestParam(value = "password") String password)
    {
        System.out.println("provider层的处理");
        return userLoginService.findUserLoginByPhoneAndPassword(phone,password);
    }

}
