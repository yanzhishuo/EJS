package com.cebbank.shopper_provider.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Create by qiram on 2020/11/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProductCategory {
    /**
     * 商品分类表主键
     */
    private Integer productCategoryId;

    /**
     * 商品分类名称
     */
    private String productCategoryName;

    /**
     * 创建时间
     */
    private String productCategoryCreateTime;

    /**
     * 更新时间
     */
    private String productCategoryUpdateTime;

    /**
     * 0删除，1正常
     */
    private Integer productCategoryStatus;
}
