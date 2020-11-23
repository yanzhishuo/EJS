package com.cebbank.shopper_provider.service;


import com.cebbank.common.pojo.PageResult;
import com.cebbank.common.pojo.Product;
import com.cebbank.common.pojo.ProductDetail;

import java.util.List;
import java.util.Map;

/**
 * Create by qiram on 2020/11/12
 */
public interface ProductService {
    /**
     * 查询商品列表（无参）
     * @return
     */
    List<Product> queryProductInfo();
    /**
     * 通过分类id查询商品列表
     * @param categoryId
     * @return
     */
    List<Product> queryProductInfoByCategoryId(int categoryId);

    /**
     * 查询商品列表（首页，无参）
     * @return
     */
    List<Map<String, Object>> queryProduct();

    /**
     * 查询商品列表（首页）
     * @param categoryId
     * @return
     */
    List<Map<String, Object>> queryProductByCategoryId(int categoryId);

//    /**
//     * 查询商品列表（首页）
//     * @param categoryId
//     * @return
//     */
//    List<Map<String, Object>> queryProductPageByCategoryId(int categoryId);

    /**
     * 商品详情页相关信息查询
     * @param propertyValue
     * @return
     */
    List<ProductDetail> queryProductsDetailByParam(String propertyValue);

    /**
     * 通过商品id和商品参数属性查询商品详请页面相关信息
     * @param id
     * @return
     */
    List<ProductDetail> queryProductsDetailByIdAndProperty(int id);

    /**
     * 分页查询接口
     *      * 这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象, 如MyBatis或JPA的分页对象
     *      * 从而避免因为替换ORM框架而导致服务层、控制层的分页接口也需要变动的情况，替换ORM框架也不会
     *      * 影响服务层以上的分页接口，起到了解耦的作用
     * @param pageNo
     * @param pageSize
     * @param categoryId
     * @return Page 自定义，统一分页查询结果
     */
    PageResult queryProductPage(int pageNo, int pageSize, int categoryId);
}
