package com.cebbank.shopper_provider.common.utils;

import com.cebbank.common.pojo.PageResult;
import com.github.pagehelper.PageInfo;

/**
 * Create by qiram on 2020/11/17
 */
public class PageUtils {
    /**
     * 将分页信息封装到统一的接口
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNo(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setPageTotal(pageInfo.getTotal());
        pageResult.setPageTotalCount(pageInfo.getPages());
        pageResult.setItems(pageInfo.getList());
        return pageResult;
    }
}
