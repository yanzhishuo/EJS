package com.cebbank.user_login_consumer.controller;

import com.cebbank.user_login_consumer.common.Constants;
import com.cebbank.user_login_consumer.common.pojo.UserInfo;
import com.cebbank.user_login_consumer.common.pojo.UserLogin;
import com.cebbank.user_login_consumer.common.utils.MD5Util;
import com.cebbank.user_login_consumer.common.utils.Result;
import com.cebbank.user_login_consumer.common.utils.ResultGenerator;
import com.cebbank.user_login_consumer.common.utils.ServiceResultEnum;
import com.cebbank.user_login_consumer.service.UserLoginService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * consumer客户端的controller 业务逻辑，前端交互
 */
//@Controller("/userlogin")
@Controller
@RequestMapping("/userlogin")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = {"/","/logineruser"})
    public String login(){
        System.out.println("显示登录界面");
        return "/mall/login" ;
    }

    @RequestMapping("/loginuser")
    public String loginUser(UserLogin userLogin)
    {
        System.out.println("login tiaozhuan");
        System.out.println(userLogin);
        UserLogin logUser=userLoginService.login(userLogin.getUserLoginPhone(),userLogin.getUserLoginPassword());
        System.out.println(logUser);
        if (null == logUser)
        {
            System.out.println("没有查到");
            UserLogin userLoginByPhone = userLoginService.findUserLoginByPhone(userLogin.getUserLoginPhone());
            if(null == userLoginByPhone){
                return "/mall/register";
            }else{
                //todo 忘记密码，修改密码
                return "/mall/findpassword";
            }
        }else {
            return "/mall/index";
        }
    }
    @RequestMapping("/setpassword")
    public String userLoginSetpassword(UserLogin userLogin){
        int i = userLoginService.modifyUserLoginByPhone(userLogin.getUserLoginPhone(), userLogin.getUserLoginPassword());
        return "/mall/login" ;
    }
    @RequestMapping("/registeruser")
    public String registerUser(){
        return "/mall/register" ;
    }

    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestParam Map<String, Object> map,
                           HttpSession httpSession) throws InvocationTargetException, IllegalAccessException {
//    public Result register(UserLogin userLogin, UserInfo userInfo,
//                           HttpSession httpSession) {

//        if (StringUtils.isEmpty(loginName)) {
//            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_NAME_NULL.getResult());
//        }
//        if (StringUtils.isEmpty(password)) {
//            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_PASSWORD_NULL.getResult());
//        }
//        if (StringUtils.isEmpty(verifyCode)) {
//            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_VERIFY_CODE_NULL.getResult());
//        }
//        String kaptchaCode = httpSession.getAttribute(Constants.MALL_VERIFY_CODE_KEY) + "";
//        if (StringUtils.isEmpty(kaptchaCode) || !verifyCode.equals(kaptchaCode)) {
//            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_VERIFY_CODE_ERROR.getResult());
//        }
        //todo 清verifyCode
        //success
//        String registerResult = userLoginService.addUser(userLogin,userInfo);
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


//    public void register(UserLogin userLogin,String username)
//    {
//        UserInfo userInfo=new UserInfo();
//        userInfo.setUserInfoName(username);
//        userLogin.setUserLoginPassword(MD5Util.md5(userLogin.getUserLoginPassword()));
//        userLoginService.register(userLogin,userInfo);
//    }

}
