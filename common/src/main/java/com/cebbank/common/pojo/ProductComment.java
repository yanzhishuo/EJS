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
public class ProductComment {
    /**
     * 商品评论表主键
     */
    private Integer productCommentId;

    /**
     * 用户详细信息id
     */
    private Integer userInfoId;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 评论详情
     */
    private String productCommentValue;

    /**
     * 0删除，1正常
     */
    private Integer productCommmentStatus;

    /**
     * 创建时间
     */
    private String productCommentCreateTime;

    /**
     * 更新时间
     */
    private String productCommentUpdateTime;
}
