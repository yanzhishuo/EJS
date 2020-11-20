package com.cebbank.user_login_provider.common.pojo;
/**
 * @author lsf
 * */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Accessors(chain = true)
public class UserLogin implements Serializable {

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
    private transient String userLoginPassword;

//    private String userLoginCreateTime;
//
//    private String userLoginUpdateTime;

    /**
     * 数据状态：1常  0删除
     */
    private Integer userLoginStatus;
}
