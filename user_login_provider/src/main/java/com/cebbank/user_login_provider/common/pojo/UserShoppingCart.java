package com.cebbank.user_login_provider.common.pojo;

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
@Accessors(chain = true)
public class UserShoppingCart{
    /**
     * 购物车id
     */
    private Integer userShoppingCartId;

    /**
     * 用户登录id
     */
    private Integer userLoginId;
    /**
     * 商品id
     */
    private Integer productId;
    /**
     * 商品数量
     */
    private Integer userShoppingCartProductNum;

//    private String userShoppingCartCreateTime;
//
//    private String userShoppingCartUpdateTime;

    /**
     * 1正常0删除
     */
    private Integer userShoppingCartStatus;
}
