package com.cebbank.shopper_consumer.service;

import com.cebbank.common.pojo.UserAddr;
import com.cebbank.common.pojo.UserCity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "service-userinfo-provider")
@Service
public interface UserAddrService {

    @RequestMapping(value = "/useraddr/list")
    public List<UserAddr> queryUserAddrs(@RequestParam(value = "userLoginId") Integer userLoginId);

    @RequestMapping(value = "/useraddr/add")
    public boolean addUserAddr(@RequestParam(value = "userLoginId") Integer userLoginId,
                               @RequestBody UserAddr userAddr);
    @RequestMapping(value = "/usercity/provinces")
    public List<UserCity> queryProvinces();

    @RequestMapping(value = "/usercity/cities")
    public List<UserCity> queryCities(@RequestParam(value = "provinceId") Integer provinceId);
    @RequestMapping(value = "/useraddr/addr")
    UserAddr findUserAddr(@RequestParam(value = "userAddrId") Integer userAddrId);
    @RequestMapping(value = "/useraddr/modify")
    void modifyUserAddr(@RequestBody UserAddr userAddr);
    @RequestMapping(value = "/useraddr/delete")
    void removeUserAddr(@RequestParam(value = "userAddrId")Integer userAddrId);
}
