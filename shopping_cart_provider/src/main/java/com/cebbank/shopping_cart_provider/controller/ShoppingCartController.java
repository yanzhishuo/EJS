package com.cebbank.shopping_cart_provider.controller;

import com.cebbank.common.pojo.UserShoppingCart;
import com.cebbank.shopping_cart_provider.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Create by qiram on 2020/11/19
 */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    //通过userLoginId查询购物车的详细信息
    @GetMapping("/detailList")
    public List<Map<String, Object>> queryShoppingCartDetailByUserLoginId(@RequestParam("userLoginId") Integer userLoginId){
        return shoppingCartService.queryShoppingCartDetailByUserLoginId(userLoginId);
    }
    //通过userLoginId查询购物车表中信息
    @GetMapping("/cartList")
    public List<UserShoppingCart> queryCartByUserLoginId(@RequestParam("userLoginId")Integer userLoginId) {
        return shoppingCartService.queryCartByUserLoginId(userLoginId);
    }

    //通过userLoginId和productDetailId查询购物车表中的某条数据
    @GetMapping("/cartdata")
    public List<UserShoppingCart> findCartByUserIdAndProductId(@RequestParam("userLoginId")Integer userLoginId,
                                                                @RequestParam("productDetailId")Integer productDetailId) {
        return shoppingCartService.findCartByUserIdAndProductId(userLoginId, productDetailId);
    }
    //向购物车的表中插入一条信息
    @PostMapping("/addCartData")
    public Integer addOneItemToCart(@RequestBody UserShoppingCart userShoppingCart){
        Integer cartId = shoppingCartService.addOneItemToShoppingCart(userShoppingCart);
        return cartId;
    }
    //修改购物车表的某条数据
    @PutMapping("/modifyCartNum")
    public void modifyOneItemInCart(@RequestParam("userLoginId") Integer userLoginId,
                                    @RequestParam("productDetailId") Integer productDetailId,
                                    @RequestParam("productNumNew") Integer productNumNew){
        shoppingCartService.modifyOneItemInCart(userLoginId,productDetailId,productNumNew);
    }
    //删除某用户购物车里的某条数据(从数据库)
    @PutMapping("/removeOneItem")
    public void removeOneItemFromCartByUserIdAndProductId(@RequestParam("userLoginId") Integer userLoginId,
                                                          @RequestParam("productDetailId") Integer productDetailId){
        shoppingCartService.removeOneItemFromCartByUserIdAndProductId(userLoginId, productDetailId);
    }
    //清空某用户的购物车,根据用户id删除购物车中所有的数据(从数据库)
    @PutMapping("/removeUserCart")
    public void removeAllCartDataByUserId(@RequestParam("userLoginId") Integer userLoginId){
        shoppingCartService.removeAllCartDataByUserId(userLoginId);
    }
    @PutMapping("/modifyProductNum")
    //更改用户购物车某件商品的加购数量(从数据库)
    public void modifyProductNumByUserIdAndProductId(@RequestParam("userLoginId")Integer userLoginId,
                                                     @RequestParam("productDetailId")Integer productDetailId,
                                                     @RequestParam("productNum")Integer productNum){
        shoppingCartService.modifyProductNumByUserIdAndProductId(userLoginId,productDetailId,productNum);
    }

}
