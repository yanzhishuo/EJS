package com.cebbank.shopping_cart_provider.dao.impl;

import com.cebbank.shopping_cart_provider.dao.ShoppingCartRedisDao;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Create by qiram on 2020/11/19
 */
@Repository
public class ShoppingCartRedisDaoImpl implements ShoppingCartRedisDao {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Override
    public void hashset(String key, String hkey, Object hval) {
        BoundHashOperations hashKey = redisTemplate.boundHashOps(key);
        hashKey.put(hkey, hval);
        //redisTemplate.opsForHash().put(key, hkey, hval);
    }
    @Override
    public Map getEntries(String key){
        return redisTemplate.boundHashOps(key).entries();
    }

    @Override
    public void deleteEntry(String key, String hkey) {
        redisTemplate.boundHashOps(key).delete(hkey);
    }

    @Override
    public void deleteAllEntries(String Key){
        redisTemplate.delete(Key);
    }

    @Override
    public Object getEntry(String key, String hkey) {
        BoundHashOperations hashKey = redisTemplate.boundHashOps(key);
        return hashKey.get(hkey);
    }
}
