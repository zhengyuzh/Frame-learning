package com.zyz.mybatis.mapper;

import com.zyz.mybatis.entity.Goods;

import java.util.List;
import java.util.Map;

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

    /**
     * @description: 使用 limit 分页查询数据
     * @author: zhengyuzhu
     * @date: 2023/11/22 10:56
     * @param: map
     * @return: java.util.List<com.zyz.mybatis.entity.Goods>
     **/
    List<Goods> queryGoodsLimit(Map<String,Object> map);

    /**
     * @description: 使用 RowBounds 分页
     * @author: zhengyuzhu
     * @date: 2023/11/22 11:12
     * @return: java.util.List<com.zyz.mybatis.entity.Goods>
     **/
    List<Goods> queryGoodsByRowBounds();

    /**
     * @description: 使用 分页插件
     * @author: zhengyuzhu
     * @date: 2023/11/22 13:40
     * @return: java.util.List<com.zyz.mybatis.entity.Goods>
     **/
    List<Goods> queryGoodByPlugin();

}
