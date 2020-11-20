package com.cebbank.management_mms_product_provider.service;

import com.cebbank.management_mms_product_provider.common.pojo.ProductCategory;

import java.util.List;

/**
 * Created by 夏晓丽 on 2020/11/13
 */
public interface ProductsCategoryService {
    /**
     * 根据level获取分类列表
     *
     * @param productCategoryLevel
     * @return
     */
    List<ProductCategory> queryByLevel(int productCategoryLevel);

}
