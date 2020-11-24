package com.cebbank.shopper_provider.mapper;

import com.cebbank.common.pojo.ProductDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * Create by qiram on 2020/11/20
 */
@Mapper
public interface ProductDetailMapper {
    /**
     * 根据商品详情ID查询详情信息
     * @param productDetailId
     * @return
     */
    ProductDetail selectProductDetailByDetailId(Integer productDetailId);
}
