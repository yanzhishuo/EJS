package com.cebbank.common.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct  {
    private Integer orderProductId;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 商品id
     */
    private Integer productDetailId;

    /**
     * 该订单商品数量
     */
    private Integer orderProductAmount;

    private String orderProductCreateTime;

    private String orderProductUpdateTime;

    private Integer orderProductStatus;

}
