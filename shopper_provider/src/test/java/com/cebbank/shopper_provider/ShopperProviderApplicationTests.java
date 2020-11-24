package com.cebbank.shopper_provider;

import com.cebbank.shopper_provider.mapper.ProductCategoryMapper;
import com.cebbank.shopper_provider.mapper.ProductDetailMapper;
import com.cebbank.shopper_provider.mapper.ProductMapper;
import com.cebbank.shopper_provider.service.ProductDetailService;
import com.cebbank.shopper_provider.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShopperProviderApplicationTests {
    @Autowired
    ProductCategoryMapper productCategoryMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductService productService;
    @Test
    void test() {
        System.out.println(productCategoryMapper.selectProductCategorys());
        //System.out.println(productCategoryMapper.selectIdByCategoryName("项链"));
    }
    @Test
    void test1(){
        System.out.println(productMapper.selectProductsDetailByIdAndProperty(1));
        System.out.println(productMapper.selectProductsDetailByIdAndProperty(1));
    }

    @Test
    public void findPage() {
        System.out.println(productService.queryProductPage(3,2,1));
    }

    @Autowired
    ProductDetailMapper productDetailMapper;
    @Autowired
    private ProductDetailService productDetailService;
    @Test
    public void test2(){
        System.out.println(productDetailService.findProductDetailByDetailId(1).toString());
    }
}
