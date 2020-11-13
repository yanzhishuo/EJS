package com.cebbank.shopper_provider.mapper;

import com.cebbank.shopper_provider.common.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Create by qiram on 2020/11/12
 */
@Mapper
public interface ProductMapper {
    /**
     * 查询商品列表
     * @return
     */
    List<Product> selectProduct();

}
