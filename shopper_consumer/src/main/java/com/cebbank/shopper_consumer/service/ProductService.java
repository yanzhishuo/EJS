package com.cebbank.shopper_consumer.service;

import com.cebbank.common.pojo.PageResult;
import com.cebbank.common.pojo.ProductDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Create by qiram on 2020/11/14
 */
@FeignClient(value = "service-shopper-provider")
@Service
public interface ProductService {
    @GetMapping("/product/list/{id}")
    List<Map<String, Object>> queryProductByCategory(@PathVariable("id") int id);

    @GetMapping("/category/getId/{category}")
    Integer findIdByCategoryName(@PathVariable("category") String category);

    @GetMapping("/product/detailList/{id}")
    List<ProductDetail> queryProdcutDetailByIdAndProperty(@PathVariable("id") int id);

    @GetMapping("/product/pageList")
    PageResult queryProductPage(@RequestParam("pageNo") int pageNo,
                                @RequestParam("pageSize") int pageSize,
                                @RequestParam("categoryId") int categoryId);
    @GetMapping("/productDetail/detailList")
    ProductDetail findProductDetailInfo(@RequestParam("productDetailId") Integer productDetailId);


}
