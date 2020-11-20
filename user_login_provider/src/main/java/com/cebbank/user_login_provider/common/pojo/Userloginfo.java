package com.cebbank.user_login_provider.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yanzhishuo
 * @create 2020-11-14-20:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Userloginfo implements Serializable {
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
     * 用户昵称
     */
    private String userInfoName;
}
