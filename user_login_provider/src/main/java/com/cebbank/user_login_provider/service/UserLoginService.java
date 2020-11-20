package com.cebbank.user_login_provider.service;


import com.cebbank.user_login_provider.common.pojo.UserInfo;
import com.cebbank.user_login_provider.common.pojo.UserLogin;

public interface UserLoginService {
    /**
     * 功能：根据id查登录用户
     * @param :登录用户的id
     */
    UserLogin findUserLoginByUserLoginId(Integer userLoginId);

    /**
     * 功能：根据手机号和密码查登录用户
     * @param :登录用户的手机号，密码
     */
    UserLogin findUserLoginByPhoneAndPassword(String phone,String password);
    /*
    功能：查找手机号是否存在
     */
    UserLogin findUserLoginByPhone(String phone);
    /*
    功能：忘记密码，更新密码
     */
    int modifyUserLoginByPhone(String phone,String password);
    /**
     * 用户注册
     *
     * @param
     *
     * @return
     */
    String register(UserLogin login, UserInfo userInfo );

}
