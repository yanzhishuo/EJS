package com.cebbank.management_mms_product_consumer.service;

import com.cebbank.management_mms_product_consumer.common.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

@FeignClient(value = "service-elasticsearch")
@Component
public interface ElasticSearchService {

    /**
     * 上架商品，在elasticsearch中添加
     * */
    @RequestMapping(value = "/products/add")
    Boolean addEsProduct(@RequestBody Product product);

    /**
     * 下架商品，在elasticsearch删除该商品
     * */
    @RequestMapping("/products/remove/{productId}")
    void removeEsProduct(@PathVariable("productId")Integer productId);

    /**
     * 修改商品信息，在elasticsearch中修改
     * */
    @RequestMapping("/products/edit")
    void editProduct(@RequestBody Product newProduct);


}
