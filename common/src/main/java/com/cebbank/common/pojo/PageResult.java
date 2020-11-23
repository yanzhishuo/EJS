package com.cebbank.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;


/**
 * Create by qiram on 2020/11/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Accessors(chain = true)
public class PageResult<T>  {
    /**
     * 当前页码
     */
    private Integer pageNo;
    /**
     * 总页码
     */
    private Long pageTotal;
    /**
     * 当前页显示数量
     */
    private Integer pageSize;
    /**
     * 总记录数
     */
    private Integer pageTotalCount;
    /**
     * 当前页数据
     */
    private List<T> items;
    /**
     * 分页条的请求地址
     */
    private String url;
}
