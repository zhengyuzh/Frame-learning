package com.zyz.mybatis.mapper;

import com.zyz.mybatis.entity.Goods;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.mapper
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-22  09:13
 * @Description: TODO
 * @Version: 1.0
 */
public interface GoodsMapper {

    /**
     * @description:  查询 商品信息
     * @author: zhengyuzhu
     * @date: 2023/11/22 9:16
     * @param: id
     * @return: com.zyz.mybatis.entity.Goods
     **/
    Goods queryGoodsById(Integer id);
}
