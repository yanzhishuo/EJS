package com.cebbank.management_mms_product_provider.mapper;


import com.cebbank.management_mms_product_provider.common.pojo.ShopEmpLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserLoginMapper {
    /**
     * 功能：根据登录id查登录用户
     * @param :登录用户的id
     */
    ShopEmpLogin selectUserLoginByUserLoginId(Integer shopEmpLoginId);

    /**
     * 功能：根据用户名和密码查找登录用户
     * @param :登录用户的用户名和密码
     */
    ShopEmpLogin selectUserLoginByPhoneAndPassword(@Param("shopEmpLoginAccount") String shopEmpLoginAccount, @Param("shopEmpLoginPassword") String shopEmpLoginPassword);
}
