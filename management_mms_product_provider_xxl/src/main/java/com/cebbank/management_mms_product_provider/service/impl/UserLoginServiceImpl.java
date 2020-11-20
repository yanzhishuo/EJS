package com.cebbank.management_mms_product_provider.service.impl;


import com.cebbank.management_mms_product_provider.common.pojo.ShopEmpLogin;
import com.cebbank.management_mms_product_provider.mapper.UserLoginMapper;
import com.cebbank.management_mms_product_provider.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired(required = false)
    private UserLoginMapper userLoginMapper;


    @Override
    public ShopEmpLogin findUserLoginByUserLoginId(Integer userLoginId)
    {
        ShopEmpLogin userLogin = userLoginMapper.selectUserLoginByUserLoginId(userLoginId);
        return userLogin;
    }
    @Override
    public ShopEmpLogin findUserLoginByPhoneAndPassword(String account,String password)
    {
        System.out.println("查数据库");
        ShopEmpLogin userLogin=userLoginMapper.selectUserLoginByPhoneAndPassword(account, password);
        System.out.println(userLogin);
        return userLogin;
    }

}
