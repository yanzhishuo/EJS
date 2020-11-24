package com.cebbank.common.pojo;

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
//@Accessors(chain = true)
public class ProductProperty {
    /**
     * 商品属性表主键
     */
    private Integer productPropertyId;

    /**
     * 商品属性名称
     */
    private String productPropertyName;

    /**
     * 创建时间
     */
    private String productPropertyCreateTime;

    /**
     * 更新时间
     */
    private String productPropertyUpdateTime;

    /**
     * 0删除，1正常
     */
    private Integer productPropertyStatus;

}
