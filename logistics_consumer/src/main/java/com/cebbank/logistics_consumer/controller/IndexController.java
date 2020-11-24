package com.cebbank.logistics_consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    //接收并处理index请求
    @RequestMapping("/index")
    public String index() {
        return "index.html";
    }

    //显示login页面
    @RequestMapping("/login")
    public String login() {
        return "login.html";
    }

    //显示register页面
    @RequestMapping("/register")
    public String register() {
        return "register.html";
    }

//    @RequestMapping("/logisticsList")
//    public  String logistic(){return "logisticsList.html";}

    /**
     * 跳转face页面
     *
     * @return
     */
    @RequestMapping("/facelogin")
    public String jump() {
        return "face";
    }

    @RequestMapping("/facereg")
    public String jump1() {
        return "facer";
    }

    @RequestMapping("/caplogin")
    public String jump2() {
        return "caplogin";
    }


}
