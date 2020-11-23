package com.cebbank.common.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ${author}
 * @since 2020-11-12
 */
@Data
@AllArgsConstructor
//@Accessors(chain = true)
@NoArgsConstructor
public class ProductCategory{

    private static final long serialVersionUID = 1L;

    /**
     * 商品分类表主键
     */
    private Integer productCategoryId;

    /**
     * 商品分类名称
     */
    private String productCategoryName;

    /**
     * 商品分类级别，1为一级分类，2为二级分类
     */
    private Integer productCategoryLevel;
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
