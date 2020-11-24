package com.cebbank.management_mms_product_provider.controller;

import com.cebbank.management_mms_product_provider.common.pojo.*;
import com.cebbank.management_mms_product_provider.common.utils.PageQueryUtil;
import com.cebbank.management_mms_product_provider.service.ProductEditService;
import com.cebbank.management_mms_product_provider.service.ProductsCategoryService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @AUTHOR Xiaxiaoli
 * @create 2020-11-12-23:44
 * provider端的controller实现与数据库的交互
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductsCategoryService productsCategoryService;

    @Autowired
    private ProductEditService productEditService;

    @RequestMapping("/saveproduct")
    public int saveProduct(@RequestBody Product product) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        product.setProductCreateTime(df.format(new Date()));// new Date()
        return productEditService.saveProduct(product);
    }

    @RequestMapping("/saveproductdetail")
    public int saveProductDetail(@RequestBody ProductDetail productDetail) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        productDetail.setProductDetailCreateTime(df.format(new Date()));// new Date()
        return productEditService.saveProductDetail(productDetail);
    }

    @RequestMapping("/save")
    public int saveProduct(@RequestParam Map<String, Object> map) throws InvocationTargetException, IllegalAccessException {
        Product product = new Product();
        ProductDetail productDetail = new ProductDetail();
        BeanUtils.populate(product, map);
        BeanUtils.populate(productDetail, map);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        productDetail.setProductDetailCreateTime(df.format(new Date()));// new Date()为获取当前系统时间
        product.setProductCreateTime(df.format(new Date()));
        productEditService.saveProduct(product);
        productDetail.setProductId(product.getProductId());
        return productEditService.saveProductDetail(productDetail);
    }

    @RequestMapping("/getcategories")
    public List<ProductCategory> queryCategoryByLevel(@RequestParam(value = "productCategoryLevel") int productCategoryLevel) {
        return productsCategoryService.queryByLevel(productCategoryLevel);
    }

//    @RequestMapping("/queryallproducts")
//    public List<ProductDetail> queryAllProducts(){
//        return productEditService.queryAllProducts();
//    }

    @RequestMapping("/getproductpage")
    public PageResult getProductPage(@RequestParam Map<String, Object> params) {
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return productEditService.getProductPage(pageUtil);
    }

    @RequestMapping("/queryproductbyproductdetailid")
    public ProductDetail queryProductByproductDetailId(@RequestParam Integer productDetailId) {
        return productEditService.queryProductByproductDetailId(productDetailId);
    }

    @RequestMapping("/queryproductcategoryname")
    public String queryProductCategoryName(@RequestParam Integer productDetailId) {
        return productEditService.queryproductCategoryNameByproductDetailId(productDetailId);
    }

    @RequestMapping("/productonsale")
    public Integer productOnSale(@RequestParam Integer productDetailId) {
        productEditService.updateProductStatusOnSale(productDetailId);
        return productEditService.productOnSale(productDetailId);
    }

    @RequestMapping("/productoffsale")
    public Integer productOffSale(@RequestParam Integer productDetailId) {
        productEditService.productOffSale(productDetailId);
        //查询具有同一product_id的，且product_detail_status为2的商品数量
        Integer res = productEditService.queryOnSaleProduct(productDetailId);
        if (res == 0) {
            //将product_status设置为0
            return productEditService.updateProductStatusOffSale(productDetailId);
        } else {
            return res;
        }
    }

    //lsf
    @RequestMapping("/judgeproducts")
    public Integer judgeProducts(@RequestParam Integer productDetailId){
        //查询具有同一product_id的，且product_detail_status为2的商品数量
        Integer res = productEditService.queryOnSaleProduct(productDetailId);
        return res;
    }
    //lsf
//    @RequestMapping("/getProductId")
//    public Integer findProductIdByDetailId(@RequestParam Integer productDetailId)
//    {
//        Integer productId=productEditService.findProductIdByDetailId(productDetailId);
//        return productDetailId;
//    }
    /**
     * 根据detailId查询productDetail
     * */
    @RequestMapping("/getProDetail")
    ProductDetail findProductDetailByDetailId(@RequestParam Integer productDetailId){
        ProductDetail productDetail=productEditService.queryProductByproductDetailId(productDetailId);
        return productDetail;
    }

    @RequestMapping("/updateproduct")
    public Integer updateProduct(@RequestParam Map<String, Object> map) throws InvocationTargetException, IllegalAccessException {
        ProductDetail productDetail = new ProductDetail();
        Product product = new Product();
        BeanUtils.populate(productDetail, map);
        BeanUtils.populate(product, map);
        productEditService.updateProduct(product);
        return productEditService.updateProductDetail(productDetail);
    }

    @RequestMapping("/productsofcategory")
    public List<Product> queryProductsOfCategory(@RequestParam Integer productCategoryId) {
        return productEditService.queryProductsOfCategory(productCategoryId);
    }

    @RequestMapping("/minprice")
    public Double minPrice(@RequestParam Integer productId){
        return productEditService.minPrice(productId);
    }

}
