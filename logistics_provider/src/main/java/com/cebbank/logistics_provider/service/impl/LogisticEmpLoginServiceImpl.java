package com.cebbank.logistics_provider.service.impl;



import com.cebbank.logistics_provider.mapper.LogisticEmpLoginMapper;
import com.cebbank.logistics_provider.pojo.LogisticEmpLogin;
import com.cebbank.logistics_provider.service.LogisticEmpLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LogisticEmpLoginServiceImpl implements LogisticEmpLoginService {


    @Autowired
    private LogisticEmpLoginMapper logisticEmpLoginMapper;


    @Override
    public void save(LogisticEmpLogin logisticEmpLogin) {
        logisticEmpLoginMapper.save(logisticEmpLogin);

    }

    //在数据库中查询是否有数据
    @Override
    public boolean findUserByPhoneAndPassword(LogisticEmpLogin logisticEmpLogin) {
        LogisticEmpLogin temp = logisticEmpLoginMapper.findUserByPhoneAndPassword(logisticEmpLogin);
        return temp == null ? false : true;
    }

    @Override
    public boolean findUserByPhone(String phone) {
        System.out.println(phone);
        LogisticEmpLogin temp = logisticEmpLoginMapper.findUserByPhone(phone);
        System.out.println(temp);
        return (temp == null) ?  true:false;
    }

}
