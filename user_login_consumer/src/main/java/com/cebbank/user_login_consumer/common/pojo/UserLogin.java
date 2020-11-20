package com.cebbank.user_login_consumer.common.pojo;
/**
 * @author lsf
 * */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Accessors(chain = true)
public class UserLogin {

    /**
     * 用户登录id
     */
    public Integer userLoginId;
    /**
     * 用户详情id
     */
    public Integer userInfoId;
    /**
     * 用户手机号
     */
    public String userLoginPhone;
    /**
     * 用户密码
     */
    public String userLoginPassword;

//    private String userLoginCreateTime;
//
//    private String userLoginUpdateTime;

    /**
     * 数据状态：1正常  0删除
     */
    public Integer userLoginStatus;
}
