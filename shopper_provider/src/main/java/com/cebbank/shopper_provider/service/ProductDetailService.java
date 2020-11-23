package com.cebbank.shopper_provider.service;


import com.cebbank.common.pojo.ProductDetail;

/**
 * Create by qiram on 2020/11/20
 */
public interface ProductDetailService {
    /**
     * 根据商品详情id查询商品详情信息
     * @param productDetailId
     * @return
     */
    ProductDetail findProductDetailByDetailId(Integer productDetailId);
}
