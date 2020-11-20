package com.cebbank.user_login_provider.mapper;

import com.cebbank.user_login_provider.common.pojo.UserInfo;
import com.cebbank.user_login_provider.common.pojo.UserLogin;
import com.cebbank.user_login_provider.common.pojo.Userloginfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserLoginMapper {
    /**
     * 功能：根据登录id查登录用户
     * @param :登录用户的id
     */
    UserLogin selectUserLoginByUserLoginId(Integer userLoginId);
    /**
     * 功能:根据用户登录id，查用户的详细信息
     */
    Userloginfo selectUserLoginfoByUserLoginId(Integer userLoginId);

    /**
     * 功能：根据手机号和密码查找登录用户
     * @param :登录用户的手机号和密码
     */
    UserLogin selectUserLoginByPhoneAndPassword(@Param("phone")String phone, @Param("password")String password);
    /*
    查找手机号是否存在:重复
     */
    UserLogin selectUserLoginByPhone(@Param("phone")String phone);

    /**
     * 忘记密码，根据手机号更新密码
     * @param phone
     * @return
     */
    int updateUserLoginByPhone(@Param("phone")String phone, @Param("password")String password);

    /**
     * 功能：保存注册信息到UserLogin
     * @param :封装login
     */
    Integer saveUserLogin(UserLogin login);

    /**
     * 功能：保存注册信息到UserInfo
     * @param :封装userinfo
     */
    Integer saveUserInfo(UserInfo userInfo);
}
