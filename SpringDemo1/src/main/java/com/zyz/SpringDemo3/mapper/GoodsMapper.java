package com.zyz.SpringDemo3.mapper;

import com.zyz.SpringDemo3.entity.Goods;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: com.zyz.SpringDemo3.mapper
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-17  16:43
 * @Description: TODO
 * @Version: 1.0
 */
public interface GoodsMapper {
    /**
     * 更新库存
     * goods表示本次用户购买的商品信息
     * @param goods
     */
    void updateGoods(Goods goods);

    /**
     * @description:查询商品信息
     * @author: zhengyuzhu
     * @date: 2023/11/17 16:44
     * @param: id
     * @return: com.zyz.SpringDemo3.entity.Goods
     **/
    Goods queryGoods(Integer id);
}

