package com.cebbank.shopping_cart_provider.mapper;

import com.cebbank.common.pojo.UserShoppingCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Create by qiram on 2020/11/19
 */
@Mapper
public interface ShoppingCartMapper {
    /**
     * 根据用户id查询购物车详情信息
     * @param userLoginId
     * @return
     */
    List<Map<String, Object>> selectShoppingCartDetailByUserLoginId(@Param("userLoginId") Integer userLoginId);

    /**
     * 查找购物车信息*  根据用户id
     * @param userLoginId
     * @return
     */
    List<UserShoppingCart> selectCartById(@Param("userLoginId") Integer userLoginId,
                                          @Param("productDetailId") Integer productDetailId);
    /**
     * 向购物车表中插入一条数据
     * @param userShoppingCart
     * @return
     */
    Integer insertOneItemToShoppingCart(UserShoppingCart userShoppingCart);

    /**
     * 更改购物车中某条数据的商品数量
     * @param userLoginId
     * @param productDetailId
     * @param productNumNew
     */
    void updateOneItemInCart(@Param("userLoginId") Integer userLoginId,
                             @Param("productDetailId") Integer productDetailId,
                             @Param("productNumNew") Integer productNumNew);

    /**
     * 根据用户id以及商品详情id从用户的购物车表里删除一条数据
     * @param userLoginId
     * @param productDetailId
     */
    void deleteOneItemFromCartByUserIdAndProductId(@Param("userLoginId") Integer userLoginId,
                                                   @Param("productDetailId") Integer productDetailId);

    /**
     * 根据用户id删除购物车中所有的数据
     * @param userLoginId
     */
    void deleteAllCartDataByUserId(@Param("userLoginId") Integer userLoginId);

    /**
     * 根据用户id以及商品详情id更新某条信息的加购数量
     * @param userLoginId
     * @param productDetailId
     * @param productNum
     */
    void updateProductNumByUserIdAndProductId(@Param("userLoginId") Integer userLoginId,
                                              @Param("productDetailId") Integer productDetailId,
                                              @Param("productNum") Integer productNum);
}
