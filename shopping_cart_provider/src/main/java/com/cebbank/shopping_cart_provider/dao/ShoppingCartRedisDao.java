package com.cebbank.shopping_cart_provider.dao;

import java.util.Map;

/**
 * Create by qiram on 2020/11/19
 */
public interface ShoppingCartRedisDao {
    /**
     * 向Redis中添加一条用户的购物车数据
     * @param key
     * @param hkey
     * @param hval
     */
    void hashset(String key, String hkey, Object hval);

    /**
     * 获取某个用户购物车中的所有商品数据
     * @return
     */
    Map getEntries(String key);

    /**
     * 删除购物车中的某件商品
     * @param key
     * @param hkey
     */
    void deleteEntry(String key,String hkey);

    /**
     * 删除某用户的购物车中的所有商品
     * @param key
     */
    void deleteAllEntries(String key);

    /**
     * 根据hkey获取一条信息
     * @param key
     * @param hkey
     * @return
     */
    Object getEntry(String key, String hkey);
}
