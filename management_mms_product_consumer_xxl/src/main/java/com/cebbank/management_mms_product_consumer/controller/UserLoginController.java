package com.cebbank.management_mms_product_consumer.controller;


import com.cebbank.management_mms_product_consumer.common.pojo.ShopEmpLogin;
import com.cebbank.management_mms_product_consumer.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * consumer客户端的controller 业务逻辑，前端交互
 */
@Controller
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = {"/admin"})
    public String login(){
        System.out.println("显示登录界面");
        return "/login" ;
    }

    @RequestMapping("/admin/loginuser")
    public String loginUser(ShopEmpLogin userLogin, Map<String,Object> map, HttpSession session)
    {
        System.out.println("login tiaozhuan");
        System.out.println(userLogin);
        ShopEmpLogin logUser=userLoginService.login(userLogin.getShopEmpLoginAccount(),userLogin.getShopEmpLoginPassword());
        System.out.println(logUser);
        if (null == logUser)
        {
            map.put("msg","输入信息不存在");
            return "/login" ;
        }else {
            session.setAttribute("loginUser", logUser.getShopEmpLoginAccount());
            System.out.println(session.getAttribute("loginUser"));
            session.setAttribute("user", logUser);
            return "/shopemp/products";
        }
    }

    @RequestMapping("/admin/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("loginUser");
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("errorMsg");
        return "/login";
    }


}
