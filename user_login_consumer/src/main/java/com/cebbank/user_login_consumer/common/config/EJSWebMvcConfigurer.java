package com.cebbank.user_login_consumer.common.config;

import com.cebbank.user_login_consumer.interceptor.AdminLoginInterceptor;
import com.cebbank.user_login_consumer.interceptor.NewBeeMallLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * @author yanzhishuo
 * 设置拦截
 * @create 2020-11-13-15:37
 *
 */
public class EJSWebMvcConfigurer {

    @Autowired
    private AdminLoginInterceptor adminLoginInterceptor;
//    @Autowired
//    private NewBeeMallLoginInterceptor newBeeMallLoginInterceptor;
//    @Autowired
//    private NewBeeMallCartNumberInterceptor newBeeMallCartNumberInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        // 添加一个拦截器，拦截以/admin为前缀的url路径（后台登陆拦截）
        registry.addInterceptor(adminLoginInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/dist/**")
                .excludePathPatterns("/admin/plugins/**");
//        // 购物车中的数量统一处理
//        registry.addInterceptor(newBeeMallCartNumberInterceptor)
//                .excludePathPatterns("/admin/**")
//                .excludePathPatterns("/register")
//                .excludePathPatterns("/login")
//                .excludePathPatterns("/logout");
//        // 商城页面登陆拦截
//        registry.addInterceptor(newBeeMallLoginInterceptor)
//                .excludePathPatterns("/admin/**")
//                .excludePathPatterns("/register")
//                .excludePathPatterns("/login")
//                .excludePathPatterns("/logout")
//                .addPathPatterns("/goods/detail/**")
//                .addPathPatterns("/shop-cart")
//                .addPathPatterns("/shop-cart/**")
//                .addPathPatterns("/saveOrder")
//                .addPathPatterns("/orders")
//                .addPathPatterns("/orders/**")
//                .addPathPatterns("/personal")
//                .addPathPatterns("/personal/updateInfo")
//                .addPathPatterns("/selectPayType")
//                .addPathPatterns("/payPage");
    }
//
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + Constants.FILE_UPLOAD_DIC);
//        registry.addResourceHandler("/goods-img/**").addResourceLocations("file:" + Constants.FILE_UPLOAD_DIC);
//    }
}
