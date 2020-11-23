package com.cebbank.shopping_cart_provider.service;

import com.cebbank.common.pojo.UserShoppingCart;

import java.util.List;
import java.util.Map;

/**
 * Create by qiram on 2020/11/19
 */
public interface ShoppingCartService {
    /**
     * 根据userLoginId查询用户的购物车清单
     * @param userLoginId
     * @return
     */
    List<Map<String, Object>> queryShoppingCartDetailByUserLoginId(Integer userLoginId);

    /**
     * 通过用户id查找相应的购物车清单
     * @param userLoginId
     * @return
     */
    List<UserShoppingCart> queryCartByUserLoginId(Integer userLoginId);

    /**
     * 通过用户ID和商品详情ID查询购物车中的某条数据
     * @param userLoginId
     * @param productDetailId
     * @return
     */
    List<UserShoppingCart> findCartByUserIdAndProductId(Integer userLoginId, Integer productDetailId);

    /**
     * 向购物车表中插入一条数据
     * @param userShoppingCart
     */
    Integer addOneItemToShoppingCart(UserShoppingCart userShoppingCart);

    /**
     *更改购物车中某条数据的商品数量
     * @param userLoginId
     * @param productDetailId
     * @param productNumNew
     */
    void modifyOneItemInCart(Integer userLoginId, Integer productDetailId, Integer productNumNew);
    /**
     * 根据用户id以及商品详情id从用户的购物车表里删除一条数据
     * @param userLoginId
     * @param productDetailId
     */
    void removeOneItemFromCartByUserIdAndProductId(Integer userLoginId, Integer productDetailId);
    /**
     * 根据用户id删除购物车中所有的数据
     * @param userLoginId
     */
    void removeAllCartDataByUserId(Integer userLoginId);
    /**
     * 根据用户id以及商品详情id更新某条信息的加购数量
     * @param userLoginId
     * @param productDetailId
     * @param productNum
     */
    void modifyProductNumByUserIdAndProductId(Integer userLoginId, Integer productDetailId, Integer productNum);
}
