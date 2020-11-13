package com.cebbank.shopper_provider.service;

import com.cebbank.shopper_provider.common.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by qiram on 2020/11/12
 */
public interface ProductService {
    /**
     * 查询商品列表（无参）
     * @return
     */
    List<Product> queryProduct();
}
