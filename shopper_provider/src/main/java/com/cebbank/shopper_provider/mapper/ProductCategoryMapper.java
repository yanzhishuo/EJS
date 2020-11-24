package com.cebbank.shopper_provider.mapper;

import com.cebbank.common.pojo.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * Create by qiram on 2020/11/14
 */
@Mapper
public interface ProductCategoryMapper {
    /**
     * 根据分类名查询分类id
     * @param category
     * @return
     */
    Integer selectIdByCategoryName(String category);

    /**
     * 查询商品分类表信息
     * @return
     */
    List<ProductCategory> selectProductCategorys();
}
