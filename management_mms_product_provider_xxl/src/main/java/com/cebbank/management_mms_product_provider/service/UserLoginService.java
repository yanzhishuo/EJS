package com.cebbank.management_mms_product_provider.service;


import com.cebbank.management_mms_product_provider.common.pojo.ShopEmpLogin;

public interface UserLoginService {
    /**
     * 功能：根据id查登录用户
     * @param :登录用户的id
     */
    ShopEmpLogin findUserLoginByUserLoginId(Integer userLoginId);

    /**
     * 功能：根据手机号和密码查登录用户
     * @param :登录用户的手机号，密码
     */
    ShopEmpLogin findUserLoginByPhoneAndPassword(String account, String password);
}
