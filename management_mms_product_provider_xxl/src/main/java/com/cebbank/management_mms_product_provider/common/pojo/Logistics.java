package com.cebbank.management_mms_product_provider.common.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Logistics {
    /**
     * 物流id
     */
    private Integer logisticsId;
    /**
     * 物流编号
     */
//    private Integer logistics_uuid;
    private String logisticsUuid;
    /**
     * 物流创建时间
     */
//    private Integer logistics_create_time;
    private String logisticsCreateTime;
    /**
     * 物流更新时间
     */
    private String logisticsUpdateTime;
    /**
     * 物流状态
     */
    private Integer logisticsStatus;
    /**
     * 订单id
     */
    private Integer orderId;

}
