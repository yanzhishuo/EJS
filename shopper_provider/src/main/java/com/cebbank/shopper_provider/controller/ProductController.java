package com.cebbank.shopper_provider.controller;

import com.cebbank.shopper_provider.common.pojo.Product;
import com.cebbank.shopper_provider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by qiram on 2020/11/12
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/list")
    public List<Product> productList(){
        return productService.queryProduct();
    }
}
