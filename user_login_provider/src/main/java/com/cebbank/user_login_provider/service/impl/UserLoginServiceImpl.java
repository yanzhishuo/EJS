package com.cebbank.user_login_provider.service.impl;

import com.cebbank.user_login_provider.common.pojo.UserLogin;
import com.cebbank.user_login_provider.common.utils.MD5Util;
import com.cebbank.user_login_provider.mapper.UserLoginMapper;
import com.cebbank.user_login_provider.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired(required = false)
    private UserLoginMapper userLoginMapper;

    @Override
    public UserLogin findUserLoginByUserLoginId(Integer userLoginId)
    {
        UserLogin userLogin=userLoginMapper.selectUserLoginByUserLoginId(userLoginId);
        return userLogin;
    }
    @Override
    public UserLogin findUserLoginByPhoneAndPassword(String phone,String password)
    {
        UserLogin userLogin=userLoginMapper.selectUserLoginByPhoneAndPassword(phone, MD5Util.md5(password));
        return userLogin;
    }
}
