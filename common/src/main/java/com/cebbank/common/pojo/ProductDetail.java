package com.cebbank.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Create by qiram on 2020/11/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 商品详情表主键
     */
    private Integer productDetailId;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 商品属性id
     */
    private Integer productPropertyId;

    /**
     * 商品属性值
     */
    private String productPropertyValue;

    /**
     * 商品价格
     */
    private Double productDetailPrice;

    /**
     * 商品库存
     */
    private Integer productDetailStock;

    /**
     * 0删除，1正常
     */
    private Integer productDetailStatus;

    /**
     * 创建时间
     */
    private String productDetailCreateTime;

    /**
     * 更新时间
     */
    private String productDetailUpdateTime;
    /**
     * 商品属性名称
     */
    private String productPropertyName;
    /**
     * 商品细节图片
     */
    private String productDetailImage;
    /**
     * 商品
     * */
    private Product product;
    /**
     * 商品图片
     */
    private String productImage;
}
