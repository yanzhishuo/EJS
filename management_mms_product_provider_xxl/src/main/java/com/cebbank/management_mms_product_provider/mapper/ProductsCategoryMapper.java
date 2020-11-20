package com.cebbank.management_mms_product_provider.mapper;

import com.cebbank.management_mms_product_provider.common.pojo.ProductCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 夏晓丽 on 2020/11/13
 */
@Mapper
public interface ProductsCategoryMapper {
    List<ProductCategory> selectByLevel(@Param("productCategoryLevel") int productCategoryLevel);
}
