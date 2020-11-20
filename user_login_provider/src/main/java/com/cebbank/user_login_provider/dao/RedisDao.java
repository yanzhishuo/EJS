package com.cebbank.user_login_provider.dao;

import com.cebbank.user_login_provider.common.pojo.UserInfo;
import com.cebbank.user_login_provider.common.pojo.UserLogin;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author yanzhishuo
 * @create 2020-11-13-15:31
 */
public interface RedisDao {
/**
 * redis存用户loginid,用户名，手机号
 */

    /**
     * 新增hashmap值
     * @param key
     * @param hkey
     * @param hval
     */
    public void hashSet(String key, String hkey, String hval);

    /**
     * 存map
     * @param key
     * @param map
     */
    public void hashSet(String key, Map<String, String> map);

    /**
     * hash:获取变量中的键值对
     * @param key
     * @return
     */
    public Map<String, String> hashGetAll(String key);

    /**
     * 给哈希表key中的指定字段的整数值加上增量increment，此处加1
     * @param key
     * @param hkey
     * @return
     */
    public Integer hashIncr(String key, String hkey);

    /**
     * 删除一个或者多个hash表字段
     * @param key
     * @param hkey
     * @return
     */
    public Integer hashdel(String key, String hkey);

    /**
     *String类型的删除 删除单个key值
     * @param key
     */
    public void delkey(String key);

    /**
     * 存userlogin对象
     * @param key
     * @param value
     */

    public void setObjlogin(String key, UserLogin value);

    /**
     * 存userinfo对象
     * @param key
     * @param value
     */

    public void setObjinfo(String key, UserInfo value) ;

    /**
     * 存userlogin对象并加上过期时间
     * @param key
     * @param value
     * @param expireSeconds
     */

    public void setObj(String key,UserLogin value, long expireSeconds);

    /**
     * 取值
     * @param key
     * @return
     */
    public UserLogin getObj(String key);

    /**
     * string类型的存值
     * @param key
     * @param value
     */
    public void setString(String key, String value) ;

    /**
     * string类型的取值
     * @param key
     * @return
     */
    public String getString(String key) ;

    /**
     * string类型的存值并设置过期时间
     * @param key
     * @param value
     * @param expireSeconds
     */

    public void setString(String key, String value, long expireSeconds) ;
}
