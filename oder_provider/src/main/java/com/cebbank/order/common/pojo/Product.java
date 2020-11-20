package com.cebbank.order.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Create by qiram on 2020/11/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product{
    /**
     * 商品表主键
     */
    private Integer productId;

    /**
     * 商品货号
     */
    private String productNo;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品图片
     */
    private String productImage;

    /**
     * 商品分类
     */
    private Integer productCategoryId;

    /**
     * 商品描述
     */
    private String productDesc;

    /**
     * 已卖数量，默认值为0
     */
    private Integer productSoldAmount;

    /**
     * 上架时间
     */
    private LocalDateTime productOnsaleTime;

    /**
     * 创建时间
     */
    private String productCreateTime;

    /**
     * 更新时间
     */
    private String productUpdateTime;

    /**
     * 商品状态，0删除，1待审核，2上架，3下架
     */
    private Integer productStatus;
}
