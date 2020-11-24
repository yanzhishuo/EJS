package com.cebbank.common.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanzhishuo
 * @create 2020-11-18-18:59
 */
@Data
@AllArgsConstructor
//@Accessors(chain = true)
@NoArgsConstructor
public class ShopEmpLogin {
    private String shopEmpLoginPassword;
    /**
     * 员工登陆人脸识别token值
     */
    private String shopEmpLoginFaceToken;

    /**
     * 商城后台员工登录id
     */

    private Integer shopEmpLoginId;

    /**
     * 员工登录账号
     */
    private String shopEmpLoginAccount;

    /**
     * 0删除 1正常
     */
    private Integer shopEmpLoginStatus;

    private String shopEmpLoginCreateTime;

    private String shopEmpLoginUpdateTime;
	/**
	*角色名
	*/
    private String shopEmpRoleName;
	/**
	*角色Id
	*/
    private Integer  shopEmpRoleId;

}
