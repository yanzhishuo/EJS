package com.cebbank.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author ${lsf}
 * @since 2020-11-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Accessors(chain = true)
public class UserInfo {
    /**
     * 用户详情id
     */
    private Integer userInfoId;
    /**
     * 用户昵称
     */
    private String userInfoName;
    /**
     * 用户头像
     */
    private String userInfoIconUrl;
    /**
     * 用户手机号
     */
    private String userInfoPhone;
    /**
     * 用户性别
     */
    private Integer userInfoGender;
    /**
     * 用户身份证号
     */
    private String userInfoIdcard;
    /**
     * 用户生日
     */
    private Date userInfoBirth;

//    private String userInfoCreateTime;
//
//    private String userInfoUpdateTime;

    /**
     * 数据状态：1正常  0删除
     */
    private Integer userInfoStatus;
}
