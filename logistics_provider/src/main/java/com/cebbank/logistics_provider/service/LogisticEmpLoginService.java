package com.cebbank.logistics_provider.service;


import com.cebbank.logistics_provider.pojo.LogisticEmpLogin;

public interface LogisticEmpLoginService {

    void save(LogisticEmpLogin user);

    boolean findUserByPhoneAndPassword(LogisticEmpLogin user);

    boolean findUserByPhone(String phone);

}
