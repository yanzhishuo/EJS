package com.cebbank.shopper_provider.service.impl;

import com.cebbank.common.pojo.ProductCategory;
import com.cebbank.shopper_provider.mapper.ProductCategoryMapper;
import com.cebbank.shopper_provider.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by qiram on 2020/11/14
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Override
    public Integer findIdByCategoryName(String category) {
        return productCategoryMapper.selectIdByCategoryName(category);
    }

    @Override
    public List<ProductCategory> queryProductCategorys() {
        return productCategoryMapper.selectProductCategorys();
    }
}
