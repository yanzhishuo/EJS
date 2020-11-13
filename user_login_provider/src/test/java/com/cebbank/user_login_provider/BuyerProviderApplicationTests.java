package com.cebbank.user_login_provider;

import com.cebbank.user_login_provider.common.pojo.UserLogin;
import com.cebbank.user_login_provider.common.utils.MD5Util;
import com.cebbank.user_login_provider.controller.UserLoginController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class BuyerProviderApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    private UserLoginController userLoginController;

    @Test
    void contextLoads() {
    }

    @Test
    public void testMD5() throws SQLException {
        System.out.println(MD5Util.md5("lsf123456"));
    }
    @Test
    public void userlogintest()
    {
        UserLogin userLogin=new UserLogin();
        userLogin.setUserLoginPhone("18698955676");
        userLogin.setUserLoginPassword("lsf123456");
        UserLogin user=userLoginController.login(userLogin);
        System.out.println(user);
    }


}
