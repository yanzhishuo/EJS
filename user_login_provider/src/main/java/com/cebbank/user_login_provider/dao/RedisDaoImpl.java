package com.cebbank.user_login_provider.dao;

import com.cebbank.user_login_provider.common.pojo.UserInfo;
import com.cebbank.user_login_provider.common.pojo.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author yanzhishuo
 * @create 2020-11-14-18:34
 */
@Repository
public class RedisDaoImpl implements RedisDao {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public void setObjlogin(String key, UserLogin value) {
        redisTemplate.opsForValue().set(key, value);
    }
    @Override
    public void setObjinfo(String key, UserInfo value) {
        redisTemplate.opsForValue().set(key, value);
    }
    @Override
    public void setObj(String key,UserLogin value, long expireSeconds) {
        redisTemplate.opsForValue().set(key, value, expireSeconds, TimeUnit.SECONDS);
    }
    @Override
    public UserLogin getObj(String key) {
        return (UserLogin)redisTemplate.opsForValue().get(key);
    }

    @Override
    public void setString(String key, String value) {
        stringRedisTemplate.opsForValue().set(key,value);
    }
    @Override
    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public void setString(String key, String value, long expireSeconds) {
        stringRedisTemplate.opsForValue().set(key, value, expireSeconds, TimeUnit.SECONDS);
    }

    @Override
    public void hashSet(String key, String hkey, String hval) {
        stringRedisTemplate.opsForHash().put(key, hkey, hval);
    }

    @Override
    public void hashSet(String key, Map<String, String> map) {
        stringRedisTemplate.opsForHash().putAll(key, map);
    }

    @Override
    public Map<String, String> hashGetAll(String key) {
        HashOperations<String, String, String> ops = stringRedisTemplate.opsForHash();
        return ops.entries(key);
    }

    @Override
    public Integer hashIncr(String key, String hkey) {
        return stringRedisTemplate.opsForHash().increment(key, hkey, 1).intValue();
    }

    @Override
    public Integer hashdel(String key, String hkey) {
        return stringRedisTemplate.opsForHash().delete(key, hkey).intValue();
    }

    @Override
    public void delkey(String key) {
        stringRedisTemplate.delete(key);
    }


}
