package com.cebbank.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Create by qiram on 2020/11/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserShoppingCartRedis implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 购物车id
     */
    private Integer userShoppingCartId;
    /**
     * 用户登录id
     */
    private Integer userLoginId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品详情表主键
     */
    private Integer productDetailId;
    /**
     * 商品数量
     */
    private Integer userShoppingCartProductNum;
    /**
     * 购物车数据状态：1正常 0删除
     */
    private String userShoppingCartStatus;
    /**
     * 商品详情
     */
    private ProductDetail productDetail;

}
