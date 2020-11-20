package com.cebbank.management_mms_product_consumer.controller;

import com.cebbank.management_mms_product_consumer.common.pojo.Product;
import com.cebbank.management_mms_product_consumer.common.pojo.ProductCategory;
import com.cebbank.management_mms_product_consumer.common.pojo.ProductDetail;
import com.cebbank.management_mms_product_consumer.common.util.Result;
import com.cebbank.management_mms_product_consumer.common.util.ResultGenerator;
import com.cebbank.management_mms_product_consumer.service.ProductCategoryService;
import com.cebbank.management_mms_product_consumer.service.ProductEditService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @AUTHOR Xiaxiaoli
 * @create 2020-11-14-16:01
 * <p>
 * consumer客户端的controller 业务逻辑，前端交互
 */
@Controller
@RequestMapping("/shopemp")
public class ProductController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductEditService productEditService;

//    @GetMapping("/products")
//    public String goodsPage(HttpServletRequest request) {
//        List<ProductDetail> productDetailList = productEditService.queryAllProducts();
//        for(ProductDetail productDetail:productDetailList)
//        {
//            if (productDetail.getProductDetailStatus() == 1){
//                productDetail.setProductDetailStatusValue("待审核");
//            }
//            if (productDetail.getProductDetailStatus() == 2){
//                productDetail.setProductDetailStatusValue("销售中");
//            }
//            if (productDetail.getProductDetailStatus() == 3){
//                productDetail.setProductDetailStatusValue("已下架");
//            }
//        }
//        request.setAttribute("path", "products");
//        request.setAttribute("productDetailList", productDetailList);
//        return "shopemp/products";
//    }

    @GetMapping("/products")
    public String goodsPage(HttpServletRequest request) {
        request.setAttribute("path", "products");
        return "shopemp/products";
    }

    @RequestMapping(value = "/products/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
//        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(productEditService.getProductPage(params));
    }

    //上架商品的同时将对应的product_status设置为1
    @RequestMapping(value = "/product/onsale/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    public String productOnSale(@PathVariable("id") Integer id) {
        productEditService.productOnSale(id);
        return "redirect:/shopemp/products";
    }

    //下架商品之后，需要查询具有同一product_id的，且product_detail_status为2的商品数量，若数量为0，则需要将product_status设置为0
    @RequestMapping(value = "/product/offsale/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    public String productOffSale(@PathVariable("id") Integer id) {
        productEditService.productOffSale(id);
        return "redirect:/shopemp/products";
    }

    @GetMapping("/product/add")
    public String edit(HttpServletRequest request) {
        request.setAttribute("path", "add");
        //查询所有的一级分类
        List<ProductCategory> firstLevelCategories = productCategoryService.queryCatogoryByLevel(1);
        if (!CollectionUtils.isEmpty(firstLevelCategories)) {
            request.setAttribute("firstLevelCategories", firstLevelCategories);
            request.setAttribute("path", "products-add");
            return "shopemp/product_add";
        }
        return "rrr/error";
    }

    @RequestMapping("/product/categories")
    @ResponseBody
    public List<ProductCategory> allCategories() {
        //查询所有的一级分类
        List<ProductCategory> firstLevelCategories = productCategoryService.queryCatogoryByLevel(1);
        return firstLevelCategories;
    }

    @RequestMapping("/product/productsofonecategory")
    @ResponseBody
    public List<Product> productsOfCategory(Integer productCategoryId) {
        //查询某个分类下的所有商品
        System.out.println(productCategoryId);
        List<Product> products = productEditService.queryProductsOfCategory(productCategoryId);
        return products;
    }

    @GetMapping("/product/addproperty")
    public String toAdd(HttpServletRequest request) {
        request.setAttribute("path", "addproperty");
        return "shopemp/product_addproperty";
    }

    //    @PostMapping(value = "/product/saveproperty")
    @RequestMapping(value = "/product/saveproperty")
    public String toEdit(HttpServletRequest request, ProductDetail productDetail) {
        productEditService.saveProductDetail(productDetail);
        return "redirect:/shopemp/products";
    }

    /**
     * 保存新增商品信息
     */
//    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    @RequestMapping(value = "/product/save")
//    @ResponseBody
    public String saveProduct(@RequestParam Map<String, Object> map) throws InvocationTargetException, IllegalAccessException {
        Product product = new Product();
        ProductDetail productDetail = new ProductDetail();
        BeanUtils.populate(product, map);
        BeanUtils.populate(productDetail, map);
        if (StringUtils.isEmpty(productDetail.getProductPropertyValue())
                || StringUtils.isEmpty(productDetail.getProductDetailPrice())
                || StringUtils.isEmpty(productDetail.getProductDetailStock())
                || StringUtils.isEmpty(product.getProductNo())
                || StringUtils.isEmpty(product.getProductName())
                || StringUtils.isEmpty(product.getProductDesc())) {
            return "rrr/error";
        }
        productEditService.save(map);
        return "redirect:/shopemp/products";
    }

    /**
     * 跳到商品信息编辑界面
     */
    @GetMapping(value = "/product/edit/{id}")
    public String toEditPage(@PathVariable("id") Integer id, HttpServletRequest request) {
        ProductDetail productDetail = productEditService.queryProductByproductDetailId(id);
        String productCategoryName = productEditService.queryproductCategoryNameByproductDetailId(id);
//        System.out.println(productCategoryName);
        request.setAttribute("path", "edit");
        request.setAttribute("productDetail", productDetail);
        request.setAttribute("productCategoryName", productCategoryName);
        return "/shopemp/product_edit";
    }

    /**
     * 修改商品信息，只能修改价格,库存和商品描述
     */
//    @RequestMapping(value = "/product/modify", method = RequestMethod.POST)
    @RequestMapping(value = "/product/modify")
    public String editProduct(@RequestParam Map<String, Object> map) {
        productEditService.updateProduct(map);
        return "redirect:/shopemp/products";
    }

}
