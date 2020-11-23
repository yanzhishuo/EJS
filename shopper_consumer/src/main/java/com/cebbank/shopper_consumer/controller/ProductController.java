package com.cebbank.shopper_consumer.controller;

import com.cebbank.common.pojo.PageResult;
import com.cebbank.common.pojo.ProductDetail;
import com.cebbank.shopper_consumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Create by qiram on 2020/11/13
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/index")
    public String indexPage(){
        return "pages/index";
    }

    @GetMapping("/product")
    @ResponseBody
    public List<Map<String, Object>> queryProductsToIndex(HttpServletRequest req) {
        String category = req.getParameter("category");
        int categoryId = productService.findIdByCategoryName(category);
        return productService.queryProductByCategory(categoryId);
    }

    @GetMapping("/detail")
    public String detailPage(HttpServletRequest req, Model model){
        Integer productId = Integer.parseInt(req.getParameter("id"));
        model.addAttribute("productId", productId);
        String productName = req.getParameter("name");
        model.addAttribute("productName", productName);
        return "pages/product/productDetail";
    }
    @GetMapping("/productDetail")
    @ResponseBody
    public List<ProductDetail>  productDetail(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("productId"));
        return productService.queryProdcutDetailByIdAndProperty(id);
    }

    @GetMapping("/category")
    public String categoryPage(HttpServletRequest req, Model model){
//        Integer productId = Integer.parseInt(req.getParameter("id"));
//        model.addAttribute("productId", productId);
        String categoryName = req.getParameter("categoryName");
        model.addAttribute("categoryName", categoryName);
        return "pages/product/productSearch";
    }

    @GetMapping("/productPage")
    @ResponseBody
    public PageResult productPage(HttpServletRequest req){
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        String category = req.getParameter("category");
        int categoryId = productService.findIdByCategoryName(category);
        return productService.queryProductPage(pageNo, pageSize, categoryId);
    }



}
