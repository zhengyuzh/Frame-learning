package com.zyz.SpringDemo3.service;

import com.zyz.SpringDemo3.entity.Goods;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/17 16:48
 * @Description:
 */
public interface IBuyGoodsService {

    /**
     * @description: 根据 ID 查询商品
     * @author: zhengyuzhu
     * @date: 2023/11/17 23:09
     * @param: id
     * @return: com.zyz.SpringDemo3.entity.Goods
     **/
     Goods queryGoodsById(Integer id);
    /**
     * @description:购买商品的方法，goodsId是购买商品的编号，nums是购买商品的数量
     * @author: zhengyuzhu
     * @date: 2023/11/17 16:48
     * @param: goodsId
     * @param: nums
     **/
    void buy(Integer goodsId,Integer nums);
}
