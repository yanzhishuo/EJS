package com.cebbank.shopper_provider.service.impl;

import com.cebbank.common.pojo.PageResult;
import com.cebbank.common.pojo.Product;
import com.cebbank.common.pojo.ProductDetail;
import com.cebbank.shopper_provider.common.utils.PageUtils;
import com.cebbank.shopper_provider.mapper.ProductMapper;
import com.cebbank.shopper_provider.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Create by qiram on 2020/11/12
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> queryProductInfo() {
        return productMapper.selectProductsInfoByParam();
    }

    @Override
    public List<Product> queryProductInfoByCategoryId(int categoryId) {
        return productMapper.selectProductsInfoByParam(categoryId);
    }

    @Override
    public List<Map<String, Object>> queryProduct() {
        List<Map<String, Object>> list = productMapper.selectProductsByParam();
        //Map<String,BigDecimal> baseMap = getBaseMap(list);
        return list;
    }

    @Override
    public List<Map<String, Object>> queryProductByCategoryId(int categoryId) {
        List<Map<String, Object>> list = productMapper.selectProductsByParam(categoryId);
        return list;
    }

    @Override
    public List<ProductDetail> queryProductsDetailByParam(String propertyValue) {
        return productMapper.selectProductsDetailByParam(propertyValue);
    }

    @Override
    public List<ProductDetail> queryProductsDetailByIdAndProperty(int id) {
        return productMapper.selectProductsDetailByIdAndProperty(id);
    }

    @Override
    public PageResult queryProductPage(int pageNo, int pageSize, int categoryId) {
        return PageUtils.getPageResult(getPageInfo(pageNo, pageSize, categoryId));
    }
    /**
     * 调用分页插件完成分页
     * @param pageNo
     * @param pageSize
     * @param id
     * @return
     */
    private PageInfo<Map<String, Object>> getPageInfo(int pageNo, int pageSize, int id) {
        //关键
        PageHelper.startPage(pageNo, pageSize);
        List<Map<String, Object>> res = productMapper.selectProductsByParam(id);
        return new PageInfo<Map<String, Object>>(res);
    }
}
