package com.cebbank.shopping_cart_provider.controller;

import com.cebbank.common.pojo.UserShoppingCartRedis;
import com.cebbank.shopping_cart_provider.service.ShoppingCartRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Create by qiram on 2020/11/20
 */
@RestController
@RequestMapping("/shoppingCartRedis")
public class ShoppingCartRedisController {
    private final static String CART_REDIS_PREFIX = "cart_";
    @Autowired
    ShoppingCartRedisService shoppingCartRedisService;
    //向Redis中插入一条详细数据
    @RequestMapping("/addProductDetail/{productDetailId}")
    public void addShoppingCartDataToRedis(@PathVariable("productDetailId") Integer productDetailId,
                                           @RequestBody UserShoppingCartRedis userShoppingCartRedis){
        Integer userLoginId = 55;
        shoppingCartRedisService.addShoppingCartData(CART_REDIS_PREFIX + userLoginId.toString(), productDetailId.toString(), userShoppingCartRedis);
    }
    //从Redis中读取某个用户的购物车列表
    @GetMapping("/cartListFromRedis")
    public Map queryShoppingCartByUserId(@RequestParam("userLoginId") String userLoginId){
        return shoppingCartRedisService.queryShoppingCartByUserId(CART_REDIS_PREFIX + userLoginId);
    }
    //删除用户购物车里的一件商品（从Redis）
    @DeleteMapping("/removeOneItemFromRedis")
    public void removeOneItemFromCart (@RequestParam("userLoginId") String userLoginId,
                                       @RequestParam("productDetailId") Integer productDetailId){
        shoppingCartRedisService.removeOneItemFromCart(CART_REDIS_PREFIX + userLoginId.toString(), productDetailId.toString());
    }
    //删除某用户购物车里的所有商品（从Redis）
    @DeleteMapping("removeUserCartFromRedis")
    public void removeUserCartFromRedis(@RequestParam("userLoginId") String userLoginId){
        shoppingCartRedisService.removeUserCartFromRedis(CART_REDIS_PREFIX + userLoginId.toString());
    }

    //根据用户id和商品详情id获取一条信息
    @GetMapping("/findCartInfo")
    UserShoppingCartRedis findCartInfo(@RequestParam("userLoginId")Integer userLoginId,
                        @RequestParam("productDetailId")Integer productDetailId){
        return shoppingCartRedisService.findEntry(CART_REDIS_PREFIX + userLoginId.toString(), productDetailId.toString());
    }

}
