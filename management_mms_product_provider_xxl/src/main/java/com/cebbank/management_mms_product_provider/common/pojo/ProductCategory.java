package com.cebbank.management_mms_product_provider.common.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2020-11-12
 */
@Data
@AllArgsConstructor
//@Accessors(chain = true)
@NoArgsConstructor
public class ProductCategory extends Model<ProductCategory> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品分类表主键
     */
    @TableId(value = "product_category_id", type = IdType.AUTO)
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
