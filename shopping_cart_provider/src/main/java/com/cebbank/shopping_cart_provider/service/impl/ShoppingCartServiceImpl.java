package com.cebbank.shopping_cart_provider.service.impl;

import com.cebbank.common.pojo.UserShoppingCart;
import com.cebbank.shopping_cart_provider.mapper.ShoppingCartMapper;
import com.cebbank.shopping_cart_provider.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Create by qiram on 2020/11/19
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public List<Map<String, Object>> queryShoppingCartDetailByUserLoginId(Integer userLoginId){
        return shoppingCartMapper.selectShoppingCartDetailByUserLoginId(userLoginId);
    }

    @Override
    public List<UserShoppingCart> queryCartByUserLoginId(Integer userLoginId) {
        return shoppingCartMapper.selectCartById(userLoginId,null);
    }

    @Override
    public List<UserShoppingCart> findCartByUserIdAndProductId(Integer userLoginId, Integer productDetailId) {
        return shoppingCartMapper.selectCartById(userLoginId, productDetailId);
    }

    @Override
    public Integer addOneItemToShoppingCart(UserShoppingCart userShoppingCart) {
        shoppingCartMapper.insertOneItemToShoppingCart(userShoppingCart);
        return userShoppingCart.getUserShoppingCartId();
    }

    @Override
    public void modifyOneItemInCart(Integer userLoginId, Integer productDetailId, Integer productNumNew) {
        shoppingCartMapper.updateOneItemInCart(userLoginId, productDetailId, productNumNew);
    }

    @Override
    public void removeOneItemFromCartByUserIdAndProductId(Integer userLoginId, Integer productDetailId) {
        shoppingCartMapper.deleteOneItemFromCartByUserIdAndProductId(userLoginId, productDetailId);
    }

    @Override
    public void removeAllCartDataByUserId(Integer userLoginId) {
        shoppingCartMapper.deleteAllCartDataByUserId(userLoginId);
    }

    @Override
    public void modifyProductNumByUserIdAndProductId(Integer userLoginId, Integer productDetailId, Integer productNum) {
        shoppingCartMapper.updateProductNumByUserIdAndProductId(userLoginId,productDetailId,productNum);
    }
}
