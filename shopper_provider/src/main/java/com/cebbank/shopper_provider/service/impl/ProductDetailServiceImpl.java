package com.cebbank.shopper_provider.service.impl;

import com.cebbank.common.pojo.ProductDetail;
import com.cebbank.shopper_provider.mapper.ProductDetailMapper;
import com.cebbank.shopper_provider.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by qiram on 2020/11/20
 */
@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    @Autowired
    private ProductDetailMapper productDetailMapper;
    @Override
    public ProductDetail findProductDetailByDetailId(Integer productDetailId) {
        return productDetailMapper.selectProductDetailByDetailId(productDetailId);
    }
}
