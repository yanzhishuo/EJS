package com.cebbank.user_login_provider.controller;

import com.cebbank.user_login_provider.common.pojo.UserInfo;
import com.cebbank.user_login_provider.common.pojo.UserLogin;
import com.cebbank.user_login_provider.common.utils.MD5Util;
import com.cebbank.user_login_provider.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;


/**
 *  * provider服务端的controller 数据库交互的方法
 *  */


@RestController
@RequestMapping("/userlogin")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("/loginbyphonepassword")
    public UserLogin login(@RequestParam(value = "phone") String phone, @RequestParam(value = "password") String password)
    {
        System.out.println("provider层的处理");
        return userLoginService.findUserLoginByPhoneAndPassword(phone,password);
    }

    @RequestMapping("/loginbyphone")
    public UserLogin loginByphone(@RequestParam(value = "phone") String phone){
        return userLoginService.findUserLoginByPhone(phone);
    }
    @RequestMapping("/updatebyphone")
    public int updatePassword(@RequestParam(value = "phone") String phone, @RequestParam(value = "password") String password){
        return userLoginService.modifyUserLoginByPhone(phone,password);
    }

    /**
     * 注册功能

     */
    @RequestMapping("/register")
    public String register(@RequestParam Map<String, Object> map) throws InvocationTargetException, IllegalAccessException {
        UserLogin userLogin = new UserLogin();
        UserInfo userInfo=new UserInfo();
        BeanUtils.populate(userLogin, map);
        String userLoginPassword = userLogin.getUserLoginPassword();
        userLogin.setUserLoginPassword(MD5Util.md5(userLoginPassword));
        BeanUtils.populate(userInfo, map);
        System.out.println(userInfo);
        System.out.println(userLogin);
        String s = userLoginService.register(userLogin, userInfo);
        return s;
    }


}
