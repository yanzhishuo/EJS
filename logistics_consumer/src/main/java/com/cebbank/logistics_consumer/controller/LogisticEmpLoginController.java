package com.cebbank.logistics_consumer.controller;

import com.cebbank.logistics_consumer.pojo.LogisticEmpLogin;
import com.cebbank.logistics_consumer.service.LogisticsService;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

@Controller
public class LogisticEmpLoginController {

    @Autowired
    private HttpSession session;

    @Autowired
//    private LogisticEmpLoginService logisticEmpLoginService;
    private LogisticsService logisticsService;


    //用户登录
    @RequestMapping("/userLogin")
    public String userLogin(LogisticEmpLogin user, Model model) {
        System.out.println(user);
        boolean success = logisticsService.findUserByPhoneAndPassword(user);
        //登录成功，在数据库中找到了对应的数据
        if (success) {
            session.setAttribute("user", user);
            //返回首页
            return "caplogin.html";
           // return "logisticsList.html";//index redirect:/logisticsList.html
        } else {
            //给一点错误信息
            model.addAttribute("error", "用户名或者密码错误！！");
            return "login.html";
        }

    }



    //用户注册
    @RequestMapping("/userRegister")
    public String userResigter(LogisticEmpLogin user) {
        System.out.println(user);

        logisticsService.save(user);

        return "redirect:/login";
    }


    @RequestMapping("/sms")
    @ResponseBody
    public String smsCode(String phone) {
        System.out.println(phone);

        //保护机制，如果用户已经注册过了，我们就不用给他发短信了
        //通过phone查找用户，看其是否注册过，如果注册过了，我们就不用给他发短信
        //如果没有注册，我们才需要给他发短信
        //select * from user where phone = ?
        //表示该用户存不存在
        boolean success = logisticsService.findUserByPhone(phone);
        String json = null;
        System.out.println(success+"未找到手机号");
        //该用户没有注册
        if (success) {
            //发送短信
            String sms = SMS(phone);

            json = "{\"message\":" + true + ",\"sms\":\"" + sms + "\"}";
        }
        //用户以及注册过了
        else {
            json = "{\"message\":" + false + "}";
        }

        return json;
    }

    //发送短信
    private String SMS(String phone) {
        //手机
        String phoneNumber = phone;
        //短信的内容
        int templateId = 200461;
        //参数
        String[] params = new String[1];
        //验证码
        String code = "";
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            code += r.nextInt(10);
        }
        //将Code放入Session中
        session.setAttribute("sms", code);
        params[0] = code;
        System.out.println(code);
        //签名
        String sign = "EJS商城";

        //拿到发送短信的核心类
        SmsSingleSender ssender = new SmsSingleSender(1400142856, "21306d751cfdf61ed433e506da242522");
        //发送短信
        try {
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber, templateId, params, sign, "", "");
            System.out.println(result);
        } catch (JSONException | HTTPException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return code;
    }

}
