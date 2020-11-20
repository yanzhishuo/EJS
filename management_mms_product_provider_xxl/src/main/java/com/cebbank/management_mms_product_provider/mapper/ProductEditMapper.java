package com.cebbank.management_mms_product_provider.mapper;

import com.cebbank.management_mms_product_provider.common.pojo.Product;
import com.cebbank.management_mms_product_provider.common.pojo.ProductDetail;
import com.cebbank.management_mms_product_provider.common.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by 夏晓丽 on 2020/11/13
 */
@Mapper
public interface ProductEditMapper {
    Integer saveProductDetail(ProductDetail productDetail);

    Integer saveProduct(Product product);

    List<ProductDetail> queryAllProducts(PageQueryUtil pageUtil);

    Integer getProductsAmount();

    Integer productOnSale(Integer productDetailId);

    Integer productOffSale(Integer productDetailId);

    ProductDetail queryProductByproductDetailId(Integer productDetailId);

    Integer updateProductDetail(ProductDetail productDetail);

    Integer updateProduct(Product product);

    String queryproductCategoryNameByproductDetailId(Integer productDetailId);

    List<Product> queryProductsOfCategory(Integer productCategoryId);

    Integer updateProductStatusOnSale(Integer productDetailId);

    Integer updateProductStatusOffSale(Integer productDetailId);

    Integer queryOnSaleProduct(Integer productDetailId);
}
