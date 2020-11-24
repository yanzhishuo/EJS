package com.cebbank.shopper_provider.controller;

import com.cebbank.shopper_provider.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Create by qiram on 2020/11/14
 */
@RestController
@RequestMapping("/category")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;
    @GetMapping("/getId/{category}")
    public Integer findIdByCategoryName(@PathVariable("category")String category){
        return productCategoryService.findIdByCategoryName(category);
    }
}
