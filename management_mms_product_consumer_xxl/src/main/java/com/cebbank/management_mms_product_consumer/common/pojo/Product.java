package com.cebbank.management_mms_product_consumer.common.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author ${author}
 * @since 2020-11-12
 */
@Data
@AllArgsConstructor
//@Accessors(chain = true)
@NoArgsConstructor
public class Product extends Model<Product> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品表主键
     */
    @TableId(value = "product_id", type = IdType.AUTO)
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
    private String productOnsaleTime;

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
    /**
     * 该种商品最低价格
     * */
    private Double lowestPrice;


}
