package com.cebbank.management_mms_product_consumer.common.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author ${author}
 * @since 2020-11-12
 */
@Data
@AllArgsConstructor
//@Accessors(chain = true)
@NoArgsConstructor
public class ProductDetail extends Model<ProductDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品详情表主键
     */
    @TableId(value = "product_detail_id", type = IdType.AUTO)
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
     * 商品状态，0删除，1待审核，2上架，3下架
     */
    private Integer productDetailStatus;
    /**
     * 商品状态文字展示
     */
    private String productDetailStatusValue;


    /**
     * 创建时间
     */
    private String productDetailCreateTime;

    /**
     * 更新时间
     */
    private String productDetailUpdateTime;

    /**
     * 商品信息
     */
    private Product product;


}
