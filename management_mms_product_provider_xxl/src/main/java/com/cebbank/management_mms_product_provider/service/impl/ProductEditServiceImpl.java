package com.cebbank.management_mms_product_provider.service.impl;

import com.cebbank.management_mms_product_provider.common.pojo.PageResult;
import com.cebbank.management_mms_product_provider.common.pojo.Product;
import com.cebbank.management_mms_product_provider.common.pojo.ProductDetail;
import com.cebbank.management_mms_product_provider.common.utils.PageQueryUtil;
import com.cebbank.management_mms_product_provider.mapper.ProductEditMapper;
import com.cebbank.management_mms_product_provider.service.ProductEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @AUTHOR Xiaxiaoli
 * @create 2020-11-13-17:26
 */
@Service
public class ProductEditServiceImpl implements ProductEditService {
    @Autowired(required = false)
    private ProductEditMapper productEditMapper;

    @Override
    public Integer saveProductDetail(ProductDetail productDetail) {
        return productEditMapper.saveProductDetail(productDetail);
    }

    @Override
    public Integer saveProduct(Product product) {
        return productEditMapper.saveProduct(product);
    }

//    @Override
//    public List<ProductDetail> queryAllProducts() {
//        return productEditMapper.queryAllProducts();
//    }

    @Override
    public PageResult getProductPage(PageQueryUtil pageUtil) {
        List<ProductDetail> productDetailList = productEditMapper.queryAllProducts(pageUtil);
        Integer total = productEditMapper.getProductsAmount();
        PageResult pageResult = new PageResult(productDetailList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public ProductDetail queryProductByproductDetailId(Integer productDetailId) {
        return productEditMapper.queryProductByproductDetailId(productDetailId);
    }

    @Override
    public Integer productOnSale(Integer productDetailId) {
        return productEditMapper.productOnSale(productDetailId);
    }

    @Override
    public Integer productOffSale(Integer productDetailId) {
        return productEditMapper.productOffSale(productDetailId);
    }

    @Override
    public Integer updateProductDetail(ProductDetail productDetail) {
        return productEditMapper.updateProductDetail(productDetail);
    }

    @Override
    public Integer updateProduct(Product product) {
        return productEditMapper.updateProduct(product);
    }

    @Override
    public String queryproductCategoryNameByproductDetailId(Integer productDetailId) {
        return productEditMapper.queryproductCategoryNameByproductDetailId(productDetailId);
    }

    @Override
    public List<Product> queryProductsOfCategory(Integer productCategoryId) {
        return productEditMapper.queryProductsOfCategory(productCategoryId);
    }

    @Override
    public Integer updateProductStatusOnSale(Integer productDetailId) {
        return productEditMapper.updateProductStatusOnSale(productDetailId);
    }

    @Override
    public Integer updateProductStatusOffSale(Integer productDetailId) {
        return productEditMapper.updateProductStatusOffSale(productDetailId);
    }

    @Override
    public Integer queryOnSaleProduct(Integer productDetailId) {
        return productEditMapper.queryOnSaleProduct(productDetailId);
    }

}
