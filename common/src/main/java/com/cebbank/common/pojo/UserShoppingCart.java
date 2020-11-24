package com.cebbank.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lsf
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserShoppingCart {
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
    private Integer productDetailId;
    /**
     * 商品数量
     */
    private Integer userShoppingCartProductNum;
    /**
     * 1正常0删除
     */
    private Integer userShoppingCartStatus;

    /**
     * 另加productDetail属性
     * */
    private ProductDetail productDetail;
}
