package com.cebbank.user_login_provider.service.impl;

import com.cebbank.user_login_provider.common.pojo.UserInfo;
import com.cebbank.user_login_provider.common.pojo.UserLogin;
import com.cebbank.user_login_provider.common.utils.MD5Util;
import com.cebbank.user_login_provider.dao.RedisDao;
import com.cebbank.user_login_provider.mapper.UserLoginMapper;
import com.cebbank.user_login_provider.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired(required = false)
    private UserLoginMapper userLoginMapper;
    @Autowired
    RedisDao redisDao;

    @Override
    public UserLogin findUserLoginByUserLoginId(Integer userLoginId)
    {
        UserLogin userLogin=userLoginMapper.selectUserLoginByUserLoginId(userLoginId);
        return userLogin;
    }
    @Override
    public UserLogin findUserLoginByPhoneAndPassword(String phone,String password)
    {
        System.out.println("查数据库");
        UserLogin userLogin=userLoginMapper.selectUserLoginByPhoneAndPassword(phone, MD5Util.md5(password));
        String key = "userloginfo:" + phone;
        redisDao.setObjlogin(key,userLogin);
        System.out.println("hhhh"+redisDao.getObj(key).toString());

//        redisDao.setObjinfo(key,userLogin);
//        redisDao.setObjinfo();
        System.out.println(userLogin);
        return userLogin;
    }
    public UserLogin findUserLoginByPhone(String phone){
        UserLogin userLogin=userLoginMapper.selectUserLoginByPhone(phone);
        return userLogin;
    }
    public int modifyUserLoginByPhone(String phone,String password){
        int userLogin = userLoginMapper.updateUserLoginByPhone(phone, MD5Util.md5(password));
        return userLogin;
    }
    @Override
    //注册进UserInfo
    public String register(UserLogin userLogin, UserInfo userInfo) {


        //userinfo获取login的phone
        userInfo.setUserInfoPhone(userLogin.getUserLoginPhone());

        userLoginMapper.saveUserInfo(userInfo);

        userLogin.setUserInfoId(userInfo.getUserInfoId());

        userLoginMapper.saveUserLogin(userLogin);
        return "success";
    }
}
