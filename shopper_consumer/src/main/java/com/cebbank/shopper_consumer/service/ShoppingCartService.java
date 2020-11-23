package com.cebbank.shopper_consumer.service;

import com.cebbank.common.pojo.UserShoppingCart;
import com.cebbank.common.pojo.UserShoppingCartRedis;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Create by qiram on 2020/11/18
 */
@FeignClient(value = "service-shopping-cart-provider")
@Service
public interface ShoppingCartService {
    //通过userLoginId和productDetailId查询购物车表中的某条数据
    @GetMapping("/shoppingCart/cartdata")
    List<UserShoppingCart> findCartByUserIdAndProductId(@RequestParam("userLoginId") Integer userLoginId,
                                                        @RequestParam("productDetailId") Integer productDetailId);
    //向购物车表中添加一条数据
    @PostMapping("/shoppingCart/addCartData")
    @ResponseBody
    Integer addOneItemToCart(@RequestBody UserShoppingCart userShoppingCart);
    //修改购物车表中的商品数量
    @PutMapping("/shoppingCart/modifyCartNum")
    void modifyOneItemInCart(@RequestParam("userLoginId") Integer userLoginId,
                                    @RequestParam("productDetailId") Integer productDetailId,
                                    @RequestParam("productNumNew") Integer productNumNew);
    //向购物车的Redis中插入一条数据
    @RequestMapping("/shoppingCartRedis/addProductDetail/{productDetailId}")
    void addShoppingCartDataToRedis(@PathVariable("productDetailId") Integer productDetailId,
                                    @RequestBody UserShoppingCartRedis userShoppingCartRedis);
    //从Redis中查询某个用户的购物车清单
    @GetMapping("/shoppingCartRedis/cartListFromRedis")
    @ResponseBody
    Map queryShoppingCartByUserId(@RequestParam("userLoginId") String userLoginId);

    //从数据库删除某用户购物车里的某条数据
    @PutMapping("/shoppingCart/removeOneItem")
    void removeOneItemFromCartByUserIdAndProductId(@RequestParam("userLoginId") Integer userLoginId,
                                                   @RequestParam("productDetailId") Integer productDetailId);
    //从Redis中删除某用户购物车里的某条数据
    //删除用户购物车里的一件商品（从Redis）
    @DeleteMapping("/shoppingCartRedis/removeOneItemFromRedis")
    void removeOneItemFromCart (@RequestParam("userLoginId") Integer userLoginId,
                                       @RequestParam("productDetailId") Integer productDetailId);
    //一键清空某用户的购物车(从数据库)
    @PutMapping("/shoppingCart/removeUserCart")
    void removeAllCartDataByUserId(@RequestParam("userLoginId") Integer userLoginId);

    ///删除某用户购物车里的所有商品（从Redis）
    @DeleteMapping("/shoppingCartRedis/removeUserCartFromRedis")
    void removeUserCartFromRedis(@RequestParam("userLoginId") Integer userLoginId);

    //更改用户购物车某件商品的加购数量(从数据库)
    @PutMapping("/shoppingCart/modifyProductNum")
    void modifyProductNumByUserIdAndProductId(@RequestParam("userLoginId")Integer userLoginId,
                                                     @RequestParam("productDetailId")Integer productDetailId,
                                                     @RequestParam("productNum")Integer productNum);
    //根据用户id和商品详情id获取一条信息
    @GetMapping("/shoppingCartRedis/findCartInfo")
    UserShoppingCartRedis findCartInfo(@RequestParam("userLoginId")Integer userLoginId,
                        @RequestParam("productDetailId")Integer productDetailId);

    }
