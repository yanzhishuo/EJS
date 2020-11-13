package com.cebbank.user_login_provider.controller;

import com.cebbank.user_login_provider.common.pojo.UserLogin;
import com.cebbank.user_login_provider.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/userlogin")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

//    @GetMapping("/login")
//    public UserLogin login(UserLogin userLogin)
//    {
//        UserLogin logUser=userLoginService.findUserLoginByPhoneAndPassword(userLogin.getUserLoginPhone(),userLogin.getUserLoginPassword());
//        if (null==logUser)
//        {
//            return null;
//        }else {
//            return logUser;
//        }
//    }

}
