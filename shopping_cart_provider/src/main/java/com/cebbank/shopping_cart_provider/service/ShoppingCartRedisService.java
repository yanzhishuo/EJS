package com.cebbank.shopping_cart_provider.service;

import com.cebbank.common.pojo.UserShoppingCartRedis;

import java.util.Map;

/**
 * Create by qiram on 2020/11/20
 */
public interface ShoppingCartRedisService {
    /**
     *向Redis中添加一条用户的购物车数据
     * @param key
     * @param hkey
     * @param userShoppingCartRedis
     */
    void addShoppingCartData(String key, String hkey, UserShoppingCartRedis userShoppingCartRedis);

    /**
     * 根据用户id从Redis中查询用户的购物车列表
     * @param userLoginId
     * @return
     */
    Map queryShoppingCartByUserId(String userLoginId);

    /**
     * 删除购物车中的某件商品
     * @param key
     * @param hkey
     */
    void removeOneItemFromCart(String key,String hkey);

    /**
     * 删除某用户的购物车中的所有商品
     * @param key
     */
    void removeUserCartFromRedis(String key);

    /**
     * 根据用户id和商品详情id获取一条信息
     * @param key
     * @param hkey
     * @return
     */
    UserShoppingCartRedis findEntry(String key, String hkey);
}
