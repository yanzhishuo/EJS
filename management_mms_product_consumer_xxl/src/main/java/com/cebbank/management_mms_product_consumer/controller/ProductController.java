package com.cebbank.management_mms_product_consumer.controller;

import com.cebbank.management_mms_product_consumer.common.pojo.Product;
import com.cebbank.management_mms_product_consumer.common.pojo.ProductCategory;
import com.cebbank.management_mms_product_consumer.common.pojo.ProductDetail;
import com.cebbank.management_mms_product_consumer.common.util.Result;
import com.cebbank.management_mms_product_consumer.common.util.ResultGenerator;
import com.cebbank.management_mms_product_consumer.service.ElasticSearchService;
import com.cebbank.management_mms_product_consumer.service.ProductCategoryService;
import com.cebbank.management_mms_product_consumer.service.ProductEditService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
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

    @Autowired
    private ElasticSearchService elasticSearchService;


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
        return ResultGenerator.genSuccessResult(productEditService.getProductPage(params));
    }

    //上架商品的同时将对应的product_status设置为1
    @RequestMapping(value = "/product/onsale/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    public String productOnSale(@PathVariable("id") Integer id) {
        productEditService.productOnSale(id);
        //上架同时在elasticsearch中新增商品信息
        ProductDetail productDetail=productEditService.findProductDetailByDetailId(id);
        if (null!=productDetail.getProduct())
        {
            Product product=productDetail.getProduct();
            product.setProductId(productDetail.getProductId());
            Double minprice=productEditService.minPrice(productDetail.getProductId());
            product.setLowestPrice(minprice);
            elasticSearchService.addEsProduct(product);
        }
        return "redirect:/shopemp/products";
    }

    //下架商品之后，需要查询具有同一product_id的，且product_detail_status为2的商品数量，若数量为0，则需要将product_status设置为0
    @RequestMapping(value = "/product/offsale/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    public String productOffSale(@PathVariable("id") Integer id) {
        productEditService.productOffSale(id);
        //下架同时判断该productDetail同属product是否还有，无则在elasticsearch中删除该product
        if(productEditService.judgeProducts(id)==0)
        {
            Integer productId=productEditService.findProductDetailByDetailId(id).getProductId();
            elasticSearchService.removeEsProduct(productId);
        }
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

    @RequestMapping(value = "/product/saveproperty")
    public String toEdit(HttpServletRequest request, ProductDetail productDetail) {
        productEditService.saveProductDetail(productDetail);
        return "redirect:/shopemp/products";
    }

    /**
     * 保存新增商品信息
     */
    @RequestMapping(value = "/product/save")
    public String saveProduct(@RequestParam("productImage") MultipartFile productImage, @RequestParam Map<String, Object> map) throws InvocationTargetException, IllegalAccessException, IOException {
        Product product = new Product();
        String filename=System.currentTimeMillis()+productImage.getOriginalFilename();
        String path=System.getProperty("user.dir")+"\\management_mms_product_consumer_xxl\\src\\main\\resources\\static\\images\\";
        File file=new File(path+filename);
        productImage.transferTo(file);
        ProductDetail productDetail = new ProductDetail();
        map.put("productImage","/images/"+filename);
        map.forEach((k,v)-> System.out.println(k+";"+v));
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
//    public String saveProduct(@RequestParam Map<String, Object> map) throws InvocationTargetException, IllegalAccessException {
//        Product product = new Product();
//        ProductDetail productDetail = new ProductDetail();
//        BeanUtils.populate(product, map);
//        BeanUtils.populate(productDetail, map);
//        if (StringUtils.isEmpty(productDetail.getProductPropertyValue())
//                || StringUtils.isEmpty(productDetail.getProductDetailPrice())
//                || StringUtils.isEmpty(productDetail.getProductDetailStock())
//                || StringUtils.isEmpty(product.getProductNo())
//                || StringUtils.isEmpty(product.getProductName())
//                || StringUtils.isEmpty(product.getProductDesc())) {
//            return "rrr/error";
//        }
//        productEditService.save(map);
//        return "redirect:/shopemp/products";
//    }

    /**
     * 跳到商品信息编辑界面
     */
    @GetMapping(value = "/product/edit/{id}")
    public String toEditPage(@PathVariable("id") Integer id, HttpServletRequest request) {
        ProductDetail productDetail = productEditService.queryProductByproductDetailId(id);
        String productCategoryName = productEditService.queryproductCategoryNameByproductDetailId(id);
        request.setAttribute("path", "edit");
        request.setAttribute("productDetail", productDetail);
        request.setAttribute("productCategoryName", productCategoryName);
        return "/shopemp/product_edit";
    }

    /**
     * 修改商品信息，只能修改价格,库存和商品描述
     */
    @RequestMapping(value = "/product/modify")
    public String editProduct(@RequestParam Map<String, Object> map) {
        productEditService.updateProduct(map);
        map.forEach((k,v)-> System.out.println(k+":"+v));
        //lsf,修改商品属性的同时在elasticsearch中修改
        Product product=new Product();
        Double lowPrice;
        if (null!=map.get("productId"))
        {
            product.setProductId(Integer.parseInt((String)map.get("productId")));
            lowPrice=productEditService.minPrice(Integer.parseInt((String)map.get("productId")));
            product.setLowestPrice(lowPrice);
        }
        if (null!=map.get("productName"))
            product.setProductName((String) map.get("productName"));
        if (null!=map.get("productImage"))
            product.setProductImage((String)map.get("productImage"));
        elasticSearchService.editProduct(product);

        return "redirect:/shopemp/products";
    }

}
