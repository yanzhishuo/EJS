package com.cebbank.user_login_consumer.service;


import com.cebbank.user_login_consumer.common.pojo.UserInfo;
import com.cebbank.user_login_consumer.common.pojo.UserLogin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "service-buyer-provider")
@Service
public interface UserLoginService {
    /**
     * 功能：根据手机号和密码查登录用户
     * @param :登录用户的手机号，密码
     */
    @RequestMapping("/userlogin/loginbyphonepassword")
    public UserLogin login(@RequestParam(value = "phone") String phone, @RequestParam(value = "password") String password);
    /*
    功能：查找手机号是否存在
     */
    @RequestMapping(value = "/userlogin/loginbyphone")
    UserLogin findUserLoginByPhone(@RequestParam(value = "phone") String phone);
    /*
    功能：忘记密码，更新密码
     */
    @RequestMapping(value = "/userlogin/updatebyphone")
    int modifyUserLoginByPhone(@RequestParam(value = "phone") String phone, @RequestParam(value = "password") String password);
    @RequestMapping(value = "/userlogin/register")
    String addUser(@RequestParam Map<String, Object> map);
//    String addUser(@RequestBody UserLogin userLogin,@RequestBody UserInfo userInfo);


}
