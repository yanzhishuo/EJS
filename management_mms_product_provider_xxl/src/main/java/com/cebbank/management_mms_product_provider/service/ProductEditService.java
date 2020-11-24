package com.cebbank.management_mms_product_provider.service;

import com.cebbank.management_mms_product_provider.common.pojo.PageResult;
import com.cebbank.management_mms_product_provider.common.pojo.Product;
import com.cebbank.management_mms_product_provider.common.pojo.ProductDetail;
import com.cebbank.management_mms_product_provider.common.utils.PageQueryUtil;

import java.util.List;

/**
 * Created by 夏晓丽 on 2020/11/13
 */
public interface ProductEditService {
    /**
     * 保存商品信息到product_detail表中
     *
     * @param productDetail
     * @return
     */
    Integer saveProductDetail(ProductDetail productDetail);

    /**
     * 保存商品信息到product_detail表中
     *
     * @param product
     * @return
     */
    Integer saveProduct(Product product);

    /**
     * 查询所有商品信息
     *
     * @return
     */
//    List<ProductDetail> queryAllProducts();

    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getProductPage(PageQueryUtil pageUtil);

    /**
     * 根据productDetailId查询商品信息
     *
     * @return
     */
    ProductDetail queryProductByproductDetailId(Integer productDetailId);

    /**
     * 将商品状态改为销售中
     *
     * @return
     */
    Integer productOnSale(Integer productDetailId);

    /**
     * 将商品状态改为下架
     *
     * @return
     */
    Integer productOffSale(Integer productDetailId);

    /**
     * 将修改过的商品信息（价格和库存）保存到product_detail中，同时将商品状态改为待审核
     *
     * @return
     */
    Integer updateProductDetail(ProductDetail productDetail);

    /**
     * 将修改过的商品信息（商品描述）保存到product中
     *
     * @return
     */
    Integer updateProduct(Product product);

    /**
     * 根据productDetailId查询商品的分类名
     *
     * @return
     */
    String queryproductCategoryNameByproductDetailId(Integer productDetailId);

    /**
     * 根据categoryId查找所有该分类下的所有商品
     *
     * @return
     */
    List<Product> queryProductsOfCategory(Integer productCategoryId);

    /**
     * 将ProductStatus设置为1
     *
     * @return
     */
    Integer updateProductStatusOnSale(Integer productDetailId);

    /**
     * 将ProductStatus设置为0
     *
     * @return
     */
    Integer updateProductStatusOffSale(Integer productDetailId);

    /**
     * 查询具有同一product_id的，且product_detail_status为2的商品数量
     *
     * @return
     */
    Integer queryOnSaleProduct(Integer productDetailId);

    /**
     * 查询具有同一product_id的商品的最低价格
     *
     * @return
     */
    Double minPrice(Integer productId);

    /**
     *
     * */
    Integer findProductIdByDetailId(Integer detailId);
}
