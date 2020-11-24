package com.cebbank.shopper_provider.controller;

import com.cebbank.common.pojo.ProductDetail;
import com.cebbank.shopper_provider.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create by qiram on 2020/11/20
 */
@Controller
@RequestMapping("/productDetail")
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService;
    @GetMapping("/detailList")
    @ResponseBody
    public ProductDetail findProductDetailInfo(@RequestParam("productDetailId") Integer productDetailId){
        return productDetailService.findProductDetailByDetailId(productDetailId);
    }
}
