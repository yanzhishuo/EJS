package com.cebbank.logistics_consumer.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.Date;

@Controller
public class KaptchaController {

    private final static String HOME_CAPTCHA_SESSION_KEY = "homeCaptcha";

    private final static String HOME_CAPTCHA_SESSION_DATE = "homeCaptchaDate";

    /**
     * captcha expire time, millis 有效时间
     */
    private final static long VALID_MILLIS_TIME = 10 * 1000;

    @Resource
    private Producer captchaProducer;

    @GetMapping("/captcha")
    public void getKaptchaImage(HttpServletResponse response) throws Exception {
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText();
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

    @PostMapping("/check")
    public String checkHomeCaptcha(HttpServletRequest req) {
        String captcha = req.getParameter("captcha");
        if (StringUtils.isEmpty(captcha)) {
            // return "未输入";
            return "caplogin.html";
        }
        String savedCaptcha = (String) req.getSession().getAttribute(HOME_CAPTCHA_SESSION_KEY);
        Date sessionDate = (Date) req.getSession().getAttribute(HOME_CAPTCHA_SESSION_DATE);
        if (captcha.equalsIgnoreCase(savedCaptcha)) {
            if (sessionDate == null
                    || System.currentTimeMillis() - sessionDate.getTime() > VALID_MILLIS_TIME) {
              //  return "验证成功";
                return "logisticsList.html";
            }
            //return "验证超时!";
            return "logisticsList.html";
            //return "caplogin.html";
        }
      //  return "验证失败"+savedCaptcha;
        return "caplogin.html";
    }

}
