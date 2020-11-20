package com.cebbank.management_mms_product_consumer.service;

import com.cebbank.management_mms_product_consumer.common.pojo.ProductCategory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 夏晓丽 on 2020/11/14
 */
@FeignClient(value = "service-mms-product-provider")
@Service
public interface ProductCategoryService {
    /**
     * 根据level获取分类列表
     *
     * @param productCategoryLevel
     * @return
     */
    @RequestMapping("/products/getcategories")
    List<ProductCategory> queryCatogoryByLevel(@RequestParam(value = "productCategoryLevel") int productCategoryLevel);

}
