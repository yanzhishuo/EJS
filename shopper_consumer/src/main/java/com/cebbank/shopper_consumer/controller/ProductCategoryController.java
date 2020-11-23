//package com.cebbank.shopper_consumer.controller;
//
//import com.cebbank.shopper_consumer.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
///**
// * Create by qiram on 2020/11/14
// */
//@Controller
//public class ProductCategoryController {
//    @Autowired
//    private ProductService productService;
//    //通过商品分类名称，查询分类ID
//    @GetMapping("/getCategoryId/{category}")
//    public Integer findProdcutCategoryId(@PathVariable("category")String category){
//        return productService.findIdByCategoryName(category);
//    }
//
//}
