package com.cebbank.shopper_provider.service;

import com.cebbank.common.pojo.ProductCategory;

import java.util.List;

/**
 * Create by qiram on 2020/11/14
 */
public interface ProductCategoryService {
    /**
     * 根据分类名查询分类id
     * @param category
     * @return
     */
    Integer findIdByCategoryName(String category);

    /**
     * 查询商品分类表信息
     * @return
     */
    List<ProductCategory> queryProductCategorys();
}
