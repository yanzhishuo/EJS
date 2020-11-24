package com.cebbank.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author ${lsf}
 * @since 2020-11-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Accessors(chain = true)
public class UserAddr{
    /**
     * 用户地址id
     */
    private Integer userAddrId;
    /**
     * 用户地址
     */
    private Integer userCityId;

    /**
     * 用户登录id
     */
    private Integer userLoginId;
    /**
     * 收货人姓名
     */
    private String userAddrReceiverName;
    /**
     * 收货人电话
     */
    private String userAddrReceiverPhone;
    /**
     * 收货人详细地址
     */
    private String userAddrDetail;
    /**
     * 邮政编码
     */
    private String userAddrPostalCode;

//    private String userAddrCreateTime;
//
//    private String userAddrUpdateTime;

    /**
     * 1正常；0删除;2默认地址
     */
    private Integer userAddrStatus;

    /**
     * 该收货地址对应 省/直辖市
     * */

    private UserCity province;
    /**
     * 该收货地址对应 市/区
     * */
    private UserCity city;
}
