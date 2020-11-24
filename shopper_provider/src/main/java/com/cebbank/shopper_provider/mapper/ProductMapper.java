package com.cebbank.shopper_provider.mapper;

import com.cebbank.common.pojo.Product;
import com.cebbank.common.pojo.ProductDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Create by qiram on 2020/11/12
 */
@Mapper
public interface ProductMapper {
    /**
     * 查询商品列表（无参）
     * @return
     */
    List<Product> selectProductsInfoByParam();
    /**
     * 通过分类id查询商品列表
     * @return
     */
    List<Product> selectProductsInfoByParam(int categoryId);
    /**
     * 查询商品列表（首页，无参）
     * @return
     */
    List<Map<String, Object>> selectProductsByParam();
    /**
     * 查询商品列表（首页，根据分类查询）
     * @return
     */
    List<Map<String, Object>> selectProductsByParam(int categoryId);

    /**
     * 查询商品详请页面相关信息
     * @param propertyValue
     * @return
     */
    List<ProductDetail> selectProductsDetailByParam(String propertyValue);
    /**
     * 通过商品id和商品参数属性查询商品详请页面相关信息
     * @param productId
     * @return
     */
    List<ProductDetail> selectProductsDetailByIdAndProperty(@Param("productId") int productId);
}
