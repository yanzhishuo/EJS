package com.cebbank.shopper_provider.service.impl;

import com.cebbank.shopper_provider.common.pojo.Product;
import com.cebbank.shopper_provider.mapper.ProductMapper;
import com.cebbank.shopper_provider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by qiram on 2020/11/12
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> queryProduct() {
        return productMapper.selectProduct();
    }
}
