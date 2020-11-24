package com.cebbank.user_login_consumer.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.cebbank.user_login_consumer.common.Constants;
import com.cebbank.user_login_consumer.common.pojo.UserInfo;
import com.cebbank.user_login_consumer.common.pojo.UserLogin;
import com.cebbank.user_login_consumer.common.utils.*;
import com.cebbank.user_login_consumer.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * consumer客户端的controller 业务逻辑，前端交互
 */
@Controller

public class UserLoginController {
    @Value("${page.index.name}")
    private String indexPage;
    @Value("${page.order.name}")
    private String orderPage;

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = {"/userlogin"})
    public String login(Integer target, Model model){
        model.addAttribute("target", target);
        return "/mall/login" ;
    }

    @ResponseBody
    @RequestMapping("/userlogin/loginuser")
    public Map<String,Object> loginUser(UserLogin userLogin,Integer target)
    {
        Map<String,Object> map = new HashMap<>();
        System.out.println("login tiaozhuan");
        System.out.println(userLogin);
        UserLogin logUser=userLoginService.login(userLogin.getUserLoginPhone(),userLogin.getUserLoginPassword());
        System.out.println("aaaaaaaa"+logUser);
        if (null == logUser)
        {
            System.out.println("没有查到");
            UserLogin userLoginByPhone = userLoginService.findUserLoginByPhone(userLogin.getUserLoginPhone());
            if(null == userLoginByPhone){
                map.put("pass",1);
                return map;
            }else{
                map.put("pass",2);
                return map;
            }
        }else {
            Map<String, String> payload = new HashMap<>();
            payload.put("id", Integer.toString(logUser.getUserLoginId()));
            payload.put("phone", logUser.getUserLoginPhone());
            String token = JWTUtils.getToken(payload);
            map.put("pass",0);
            map.put("state", true);
            map.put("msg", "登录成功");
            map.put("token", token);
            map.put("message",indexPage);
            System.out.println(map);
            //转向目标页面
            if (target == null) {
                System.out.println(target);
                map.put("message", indexPage);
            }
            else if (target == 0) {
                System.out.println("hhhhh");
                map.put("message", orderPage);
            }else{
                System.out.println(target);
            }

            return map;
        }
    }
    @RequestMapping("/userlogin/updatepassword")
    public String updateuserLoginpassword(){
        System.out.println("显示修改密码界面");
        return "/mall/findpassword";
    }


    @RequestMapping("/userlogin/setpassword")
    public String userLoginSetpassword(UserLogin userLogin,@RequestParam("userLoginrePassword") String userLoginrePassword,
                                       Map<String,Object> map){
        if(!userLoginrePassword.equals(userLogin.getUserLoginPassword())){
            map.put("msg","密码不一致");
            return "/mall/findpassword";
        }else{
            int i = userLoginService.modifyUserLoginByPhone(userLogin.getUserLoginPhone(), userLogin.getUserLoginPassword());
            return "/mall/login" ;
        }
    }
    @RequestMapping("/userlogin/registeruser")
    public String registerUser(){
        return "/mall/register" ;
    }

    @PostMapping("/userlogin/register")
    @ResponseBody
    public Result register(@RequestParam Map<String, Object> map,
                           HttpSession httpSession) throws InvocationTargetException, IllegalAccessException {
        String registerResult = userLoginService.addUser(map);
        System.out.println(registerResult);
        System.out.println(ServiceResultEnum.SUCCESS.getResult());

//        //注册成功
        if (ServiceResultEnum.SUCCESS.getResult().equals(registerResult)) {
            return ResultGenerator.genSuccessResult();
        }
////        //注册失败
        return ResultGenerator.genFailResult(registerResult);
    }

}
