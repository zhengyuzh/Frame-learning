package com.zyz.SpringDemo3.mapper;

import com.zyz.SpringDemo3.entity.Sale;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: com.zyz.SpringDemo3.mapper
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-17  16:43
 * @Description: TODO
 * @Version: 1.0
 */
public interface SaleMapper {
    //增加销售记录
    void addSale(Sale sale);
}
