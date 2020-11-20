
package com.cebbank.management_mms_product_consumer.config;


import com.cebbank.management_mms_product_consumer.interceptor.AdminLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class NeeBeeMallWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private AdminLoginInterceptor adminLoginInterceptor;
//    @Autowired
//    private NewBeeMallLoginInterceptor newBeeMallLoginInterceptor;
//    @Autowired
//    private NewBeeMallCartNumberInterceptor newBeeMallCartNumberInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        // 添加一个拦截器，拦截以/admin为前缀的url路径（后台登陆拦截）
       registry.addInterceptor(adminLoginInterceptor)
//                .addPathPatterns("/admin/loginuser")
               .addPathPatterns("/shopemp/**")
               .addPathPatterns("/order/**")
                .excludePathPatterns("/admin");
    }

//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + Constants.FILE_UPLOAD_DIC);
//        registry.addResourceHandler("/goods-img/**").addResourceLocations("file:" + Constants.FILE_UPLOAD_DIC);
//    }
}
