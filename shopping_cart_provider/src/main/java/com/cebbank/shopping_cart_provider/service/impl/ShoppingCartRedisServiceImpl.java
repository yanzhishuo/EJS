package com.cebbank.shopping_cart_provider.service.impl;

import com.cebbank.common.pojo.UserShoppingCartRedis;
import com.cebbank.shopping_cart_provider.dao.ShoppingCartRedisDao;
import com.cebbank.shopping_cart_provider.service.ShoppingCartRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Create by qiram on 2020/11/20
 */
@Service
public class ShoppingCartRedisServiceImpl implements ShoppingCartRedisService {
    @Autowired
    private ShoppingCartRedisDao shoppingCartRedisDao;

    @Override
    public void addShoppingCartData(String key, String hkey, UserShoppingCartRedis userShoppingCartRedis) {
        shoppingCartRedisDao.hashset(key, hkey, userShoppingCartRedis);
    }

    @Override
    public Map queryShoppingCartByUserId(String userLoginId) {
        return shoppingCartRedisDao.getEntries(userLoginId);
    }

    @Override
    public void removeOneItemFromCart(String key, String hkey) {
        shoppingCartRedisDao.deleteEntry(key, hkey);
    }

    @Override
    public void removeUserCartFromRedis(String key) {
        shoppingCartRedisDao.deleteAllEntries(key);
    }

    @Override
    public UserShoppingCartRedis findEntry(String key, String hkey) {
        return (UserShoppingCartRedis) shoppingCartRedisDao.getEntry(key,hkey);
    }
}
