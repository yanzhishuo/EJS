package com.cebbank.management_mms_product_provider.service.impl;

import com.cebbank.management_mms_product_provider.common.pojo.ProductCategory;
import com.cebbank.management_mms_product_provider.mapper.ProductsCategoryMapper;
import com.cebbank.management_mms_product_provider.service.ProductsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @AUTHOR Xiaxiaoli
 * @create 2020-11-13-10:39
 */
@Service
public class ProductsCategoryServiceImpl implements ProductsCategoryService {
    @Autowired(required = false)
    private ProductsCategoryMapper productsCategoryMapper;

    @Override
    public List<ProductCategory> queryByLevel(int productCategoryLevel) {
        return productsCategoryMapper.selectByLevel(productCategoryLevel);
    }
}
