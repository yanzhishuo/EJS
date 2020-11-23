
package com.cebbank.logistics_consumer.config;

import com.cebbank.logistics_consumer.interceptor.AdminLoginInterceptor;
import com.cebbank.logistics_consumer.interceptor.LogisticLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class NeeBeeMallWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private LogisticLoginInterceptor logisticLoginInterceptor;
//    @Autowired
//    private NewBeeMallLoginInterceptor newBeeMallLoginInterceptor;
//    @Autowired
//    private NewBeeMallCartNumberInterceptor newBeeMallCartNumberInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        // 添加一个拦截器，拦截以/admin为前缀的url路径（后台登陆拦截）
       registry.addInterceptor(logisticLoginInterceptor)
               .addPathPatterns("/logistics/");
    }


}
