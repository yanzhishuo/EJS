package com.cebbank.management_mms_product_consumer.service;

import com.cebbank.management_mms_product_consumer.common.pojo.Product;
import com.cebbank.management_mms_product_consumer.common.pojo.ProductDetail;
import com.cebbank.management_mms_product_consumer.common.util.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by 夏晓丽 on 2020/11/14
 */
@FeignClient(value = "service-mms-product-provider")
@Service
public interface ProductEditService {
    /**
     * 保存商品信息到product_detail表中
     *
     * @param productDetail
     * @return
     */
    @RequestMapping("/products/saveproductdetail")
//    Integer saveProductDetail(@RequestParam Map<String,Object> map);
    Integer saveProductDetail(@RequestBody ProductDetail productDetail);

    /**
     * 保存商品信息到product_detail表中
     *
     * @param product
     * @return
     */
    @RequestMapping("/products/saveproduct")
//    Integer saveProduct(@RequestParam Map<String,Object> map);
    Integer saveProduct(@RequestBody Product product);


    /**
     * 保存商品信息到product_detail表和product表中
     *
     * @param map
     * @return
     */
    @RequestMapping("/products/save")
    Integer save(@RequestParam Map<String, Object> map);

    /**
     * 查询所有商品信息
     *
     * @return
     */
    @RequestMapping("/products/queryallproducts")
    List<ProductDetail> queryAllProducts();

    /**
     * 商品信息分页
     *
     * @return
     */
    @RequestMapping("/products/getproductpage")
    PageResult getProductPage(@RequestParam Map<String, Object> params);


    /**
     * 根据productDetailId查询商品信息
     *
     * @return
     */
    @RequestMapping("/products/queryproductbyproductdetailid")
    ProductDetail queryProductByproductDetailId(@RequestParam Integer productDetailId);

    /**
     * 将商品状态改为销售中
     *
     * @return
     */
    @RequestMapping("/products/productonsale")
    Integer productOnSale(@RequestParam Integer productDetailId);

    /**
     * 将商品状态改为已下架
     *
     * @return
     */
    @RequestMapping("/products/productoffsale")
    Integer productOffSale(@RequestParam Integer productDetailId);

    /**
     * 根据productDetailId查询商品的分类名
     *
     * @return
     */
    @RequestMapping("/products/queryproductcategoryname")
    String queryproductCategoryNameByproductDetailId(@RequestParam Integer productDetailId);

    /**
     * 将修改过的商品信息保存到数据库中
     *
     * @return
     */
    @RequestMapping("/products/updateproduct")
    Integer updateProduct(@RequestParam Map<String, Object> map);

    /**
     * 根据categoryId查找所有该分类下的所有商品
     *
     * @return
     */
    @RequestMapping("/products/productsofcategory")
    List<Product> queryProductsOfCategory(@RequestParam Integer productCategoryId);

    /**
     * 查询具有同一product_id的商品的最低价格
     *
     * @return
     */
    @RequestMapping("/products/minprice")
    Double minPrice(@RequestParam Integer productId);

    /**
     * 查询同一productdetail所属product是否还有在销
     * */
    @RequestMapping("/products/judgeproducts")
    Integer judgeProducts(@RequestParam Integer productDetailId);

    /**
     * 根据detailId查询productDetail
     * */
    @RequestMapping("/products/getProDetail")
    ProductDetail findProductDetailByDetailId(@RequestParam Integer productDetailId);
}
