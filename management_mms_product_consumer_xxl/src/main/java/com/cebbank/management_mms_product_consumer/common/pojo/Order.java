package com.cebbank.management_mms_product_consumer.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 用户登录信息
     */
    private  Integer userLoginId;
    /**
     * 物流id
     */
    private Integer logisticsId;
    /**
     * 订单创建时间
     */
    private String orderCreateTime;
    /**
     * 订单更新时间
     */
    private String orderUpdateTime;
    /**
     * 订单支付金额
     */
    private Double orderPayment;
    /**
     * 订单支付时间
     */
    private Date orderPaymentTime;
    /**
     * 发货时间
     */
    private Date orderConsignTime;
    /**
     * 交易完成时间
     */
    private Date orderEndTime;
    /**
     * 交易关闭时间
     */
    private Date orderCloseTime;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 订单编号
     */
    private String orderUuid;
    private String logisticsUuid;

}
