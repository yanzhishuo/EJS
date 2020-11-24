package com.cebbank.shopper_provider.controller;

import com.cebbank.common.pojo.PageResult;
import com.cebbank.common.pojo.Product;
import com.cebbank.common.pojo.ProductDetail;
import com.cebbank.shopper_provider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Create by qiram on 2020/11/12
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/list/{id}")
    public List<Map<String, Object>> queryProductByCategoryId(@PathVariable("id") int id){
        return productService.queryProductByCategoryId(id);
    }
    @GetMapping("/listAll")
    public List<Map<String, Object>> queryProduct(){
        return productService.queryProduct();
    }
    @GetMapping("/infoList/{id}")
    public List<Product> productInfoList(@PathVariable("id") int id){
        return productService.queryProductInfoByCategoryId(id);
    }
    @GetMapping("/infoListAll")
    public List<Product> productInfoList1(){
        return productService.queryProductInfo();
    }

    @GetMapping("/detailListAll/{param}")
    public List<ProductDetail> productDetailList(@PathVariable("param") String param){
        return productService.queryProductsDetailByParam(param);
    }
    @GetMapping("/detailList/{id}")
    public List<ProductDetail> queryProductDetailByIdAndProperty(@PathVariable("id") int id){
        //th:href="@{/Controller/behavior(param1=${param1},param2=${person.id})}"。就是使用逗号隔开多个参数！！！
        //System.out.println("QQQQQQQQQQQQQQ"+id);
        return productService.queryProductsDetailByIdAndProperty(id);
    }
    @GetMapping("/pageList")
    public PageResult queryProductPage(@RequestParam("pageNo") int pageNo,
                                       @RequestParam("pageSize") int pageSize,
                                       @RequestParam("categoryId") int categoryId){
        return productService.queryProductPage(pageNo, pageSize, categoryId);
    }

}
