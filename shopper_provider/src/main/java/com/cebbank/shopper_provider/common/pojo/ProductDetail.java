package com.cebbank.shopper_provider.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * Create by qiram on 2020/11/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProductDetail {
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
    private BigDecimal productDetailPrice;

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
}
