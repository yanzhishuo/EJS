package com.cebbank.shopper_consumer.controller;

import com.cebbank.common.pojo.ProductDetail;
import com.cebbank.common.pojo.UserShoppingCart;
import com.cebbank.common.pojo.UserShoppingCartRedis;
import com.cebbank.shopper_consumer.service.ProductService;
import com.cebbank.shopper_consumer.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Create by qiram on 2020/11/18
 */
@Controller
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ProductService productService;

    //跳转到购物车页面
    @GetMapping("/cartPage")
    public String shoppingCartPage(){
        return "pages/cart/shoppingCart";
    }

    //添加商品到购物车
    @RequestMapping("/addProductToCart")
    @ResponseBody
    public String addProductToCart(@RequestParam("productDetailId") Integer productDetailId,
                                   @RequestParam("productNum") Integer productNum,
                                   @RequestParam("productName") String productName){
        Integer userLoginId = 55;
        //先将数据插入购物车表中
        //////先查询购物车表中有没有该商品(userId)
        List<UserShoppingCart> cartInfo = shoppingCartService.findCartByUserIdAndProductId(userLoginId,productDetailId);
        UserShoppingCart userShoppingCart = new UserShoppingCart();
        Integer cartId = 0;//购物车主键
        if(cartInfo.size() == 0){//购物车中没有该商品信息
            userShoppingCart.setUserLoginId(userLoginId);
            userShoppingCart.setProductDetailId(productDetailId);
            userShoppingCart.setUserShoppingCartProductNum(productNum);
            //插入信息
            cartId = shoppingCartService.addOneItemToCart(userShoppingCart);
        }else {//购物车中存在该商品信息
            //查找原来购物车中的商品数量
            userShoppingCart = cartInfo.get(0);
            int num = userShoppingCart.getUserShoppingCartProductNum();
            cartId = userShoppingCart.getUserShoppingCartId();
            productNum += num;
            //更新商品数量(原数量+新数量)
            shoppingCartService.modifyOneItemInCart(userLoginId, productDetailId, productNum);
        }
        //然后根据商品详情id查询商品的详情信息
        ProductDetail productDetail = productService.findProductDetailInfo(productDetailId);
        //将商品详情存入Redis中
        //////设置购物车对象userShoppingCartRedis的值
        UserShoppingCartRedis userShoppingCartRedis = new UserShoppingCartRedis();
        userShoppingCartRedis.setProductName(productName);
        userShoppingCartRedis.setProductDetail(productDetail);
        userShoppingCartRedis.setUserShoppingCartId(cartId);
        userShoppingCartRedis.setUserLoginId(userLoginId);
        userShoppingCartRedis.setProductDetailId(productDetailId);
        userShoppingCartRedis.setUserShoppingCartProductNum(productNum);
        userShoppingCartRedis.setUserShoppingCartStatus("1");
        //////将购物车对象放入Redis（key:userLoginId hkey:productDetailId hval:userShoppingCartRedis）
        shoppingCartService.addShoppingCartDataToRedis(productDetailId, userShoppingCartRedis);
        return "success";
    }
    //从Redis中加载购物车中的数据
    @GetMapping("/cartList")
    @ResponseBody
    public Map queryShoppingCartByUserId(@RequestParam("userLoginId") String userLoginId){
        return shoppingCartService.queryShoppingCartByUserId(userLoginId);
    }
    //删除用户购物车里的一件商品
    @RequestMapping("/removeOneItemFromCart")
    @ResponseBody
    public String removeOneItemFromCart (@RequestParam("userLoginId") Integer userLoginId,
                                       @RequestParam("productDetailId") Integer productDetailId){
        //从数据库中删除
        shoppingCartService.removeOneItemFromCartByUserIdAndProductId(userLoginId, productDetailId);
        //从Redis中删除
        shoppingCartService.removeOneItemFromCart(userLoginId, productDetailId);
        return "success";
    }
    //一键清空购物车
    @RequestMapping("/removeUserCart")
    @ResponseBody
    public String removeUserCartByUserId(@RequestParam("userLoginId") Integer userLoginId){
        //删除数据库中的数据
        shoppingCartService.removeAllCartDataByUserId(userLoginId);
        //删除Redis中的数据
        shoppingCartService.removeUserCartFromRedis(userLoginId);
        return "success";
    }

    //更改用户某件商品的加购数量（+1,-1）
    @RequestMapping("/modifyProductNum")
    @ResponseBody
    public String modifyProductNum(@RequestParam("userLoginId")Integer userLoginId,
                                   @RequestParam("productDetailId")Integer productDetailId,
                                   @RequestParam("productNum")Integer productNum){
        //更改数据库中的数量
        shoppingCartService.modifyProductNumByUserIdAndProductId(userLoginId,productDetailId,productNum);
        //更改Redis中的数量
        //////从Redis中查取该商品的详情信息
        UserShoppingCartRedis userShoppingCartRedis = shoppingCartService.findCartInfo(userLoginId,productDetailId);
        //////更新数量
        userShoppingCartRedis.setUserShoppingCartProductNum(productNum);
        //////放回Redis中
        shoppingCartService.addShoppingCartDataToRedis(productDetailId, userShoppingCartRedis);
        return "success";
    }

}
