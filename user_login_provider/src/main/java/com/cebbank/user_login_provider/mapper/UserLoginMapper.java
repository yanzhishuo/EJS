package com.cebbank.user_login_provider.mapper;

import com.cebbank.user_login_provider.common.pojo.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * @author ${lsf}
 * @since 2020-11-12
 */
@Mapper
public interface UserLoginMapper {
    /**
     * 功能：根据登录id查登录用户
     * @param :登录用户的id
     */
    UserLogin selectUserLoginByUserLoginId(Integer userLoginId);

    /**
     * 功能：根据手机号和密码查找登录用户
     * @param :登录用户的手机号和密码
     */
    UserLogin selectUserLoginByPhoneAndPassword(@Param("phone")String phone, @Param("password")String password);
}
