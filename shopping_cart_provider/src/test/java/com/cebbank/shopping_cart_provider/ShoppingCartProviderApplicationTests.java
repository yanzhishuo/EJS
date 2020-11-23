package com.cebbank.shopping_cart_provider;

import com.cebbank.common.pojo.ProductDetail;
import com.cebbank.common.pojo.UserShoppingCart;
import com.cebbank.common.pojo.UserShoppingCartRedis;
import com.cebbank.shopping_cart_provider.dao.ShoppingCartRedisDao;
import com.cebbank.shopping_cart_provider.mapper.ShoppingCartMapper;
import com.cebbank.shopping_cart_provider.service.ShoppingCartRedisService;
import com.cebbank.shopping_cart_provider.service.ShoppingCartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class ShoppingCartProviderApplicationTests {

    @Autowired
    ShoppingCartRedisDao shoppingCartRedisDao;
    @Autowired
    ShoppingCartService shoppingCartService;
    @Autowired
    ShoppingCartRedisService shoppingCartRedisService;
    @Test
    void test(){
        UserShoppingCartRedis o = new UserShoppingCartRedis();
        o.setProductDetailId(1);
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductDetailId(1);
        o.setProductDetail(productDetail);
        shoppingCartRedisService.addShoppingCartData("cart_hahahahah","1", o);

    }
    @Test
    void test2(){
        Map map = shoppingCartRedisDao.getEntries("cart_55");
        map.forEach((key, value) -> {
            System.out.println(key + ":" + value.toString());
        });
    }
    @Test
    void test3(){
        shoppingCartRedisService.removeOneItemFromCart("cart_55","1");
    }
    @Test
    void test4(){
        //shoppingCartService.addOneItemToShoppingCart(2, 1, 5);
    }

    @Test
    void test5(){
        shoppingCartService.modifyOneItemInCart(1,1,3);
    }
    @Autowired
    ShoppingCartMapper shoppingCartMapper;
    @Test
    void test6(){
        UserShoppingCart userShoppingCart = new UserShoppingCart();
        userShoppingCart.setUserLoginId(66);
        userShoppingCart.setProductDetailId(4);
        userShoppingCart.setUserShoppingCartProductNum(2);
        shoppingCartMapper.insertOneItemToShoppingCart(userShoppingCart);

        System.out.println(userShoppingCart.getUserShoppingCartId());
    }
    @Test
    void test7(){
        shoppingCartService.removeOneItemFromCartByUserIdAndProductId(66,4);
    }

    @Test
    void test8(){
        shoppingCartService.removeAllCartDataByUserId(66);
    }
    @Test
    void test9(){
        shoppingCartRedisService.removeUserCartFromRedis("daisytest");
    }
    @Test
    void  test10(){
        shoppingCartService.modifyProductNumByUserIdAndProductId(55,1,777);
    }
}
