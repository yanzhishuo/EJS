package com.cebbank.logistics_provider.mapper;

import com.cebbank.logistics_provider.pojo.LogisticEmpLogin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LogisticEmpLoginMapper {

    @Insert("insert into logistic_emp_login(logistic_emp_login_phone,logistic_emp_login_password) values(#{logisticEmpLoginPhone},#{logisticEmpLoginPassword})")
    void save(LogisticEmpLogin user);

    @Select("select logistic_emp_login_id,logistic_emp_login_phone,logistic_emp_login_password from logistic_emp_login where logistic_emp_login_phone = #{logisticEmpLoginPhone} and logistic_emp_login_password = #{logisticEmpLoginPassword}")
    LogisticEmpLogin findUserByPhoneAndPassword(LogisticEmpLogin user);

    @Select("select logistic_emp_login_id,logistic_emp_login_phone,logistic_emp_login_password from logistic_emp_login where logistic_emp_login_phone = #{logisticEmpLoginPhone}")
    LogisticEmpLogin findUserByPhone(String logisticEmpLoginPhone);

}
