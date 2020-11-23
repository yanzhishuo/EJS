package com.cebbank.common.pojo;
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
    private Integer userLoginId;
    /**
     * 用户详情id
     */
    private Integer userInfoId;
    /**
     * 用户手机号
     */
    private String userLoginPhone;
    /**
     * 用户密码
     */
    private String userLoginPassword;

//    private String userLoginCreateTime;
//
//    private String userLoginUpdateTime;

    /**
     * 数据状态：1正常  0删除
     */
    private Integer userLoginStatus;
}
