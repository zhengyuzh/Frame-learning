package com.zyz.SpringDemo3.service.impl;

import com.zyz.SpringDemo3.entity.Goods;
import com.zyz.SpringDemo3.entity.Sale;
import com.zyz.SpringDemo3.mapper.GoodsMapper;
import com.zyz.SpringDemo3.mapper.SaleMapper;
import com.zyz.SpringDemo3.service.IBuyGoodsService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: com.zyz.SpringDemo3.service.impl
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-17  16:49
 * @Description: TODO
 * @Version: 1.0
 */
public class BuyGoodsServiceImpl implements IBuyGoodsService {

    private SaleMapper saleMapper;
    private GoodsMapper goodsMapper;

    //set注入赋值
    public void setSaleMapper(SaleMapper saleMapper) {
        this.saleMapper = saleMapper;
    }

    public void setGoodsMapper(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    /**
     * @description: 更具ID 查询商品
     * @author: zhengyuzhu
     * @date: 2023/11/17 23:08
     * @param: id
     * @return: com.zyz.SpringDemo3.entity.Goods
     **/
    @Override
    public Goods queryGoodsById(Integer id) {
        Goods goods = null;
        goods = goodsMapper.queryGoods(id);
        return goods;
    }


    /**
     * 购买商品方法
     * goodsId表示要购买的商品编号，nums表示购买的数量
     *
     * @param goodsId
     * @param nums
     */

    /*
        1、@Transactional定义在需要加入事务处理的方法上面
        2、rollbackFor
            1）当方法发生的异常属于rollbackFor，事务就会回滚
            2）当方法发生的异常不属于rollbackFor，spring就会判断发生的异常是不是运行时异常，
               若是运行时异常，事务就会回滚

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    NullPointerException.class,
                    NotEnoughException.class
            }

    )*/

    //开发中推荐使用默认值，直接使用@Transactional注解
    @Transactional
    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("buy开始...");

        /*
            记录销售的信息，向sale表添加记录，由于sale表id是自增长的，所以不需要设置id属性
            向sale表添加一条购买记录
         */
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleMapper.addSale(sale);

        //更新库存
        //先查询该编号的商品是否存在
        Goods goods = goodsMapper.queryGoods(goodsId);
        //进行判断
        if (goods == null) {
            //说明商品不存在
            throw new NullPointerException("编号为:" + goodsId + "商品不存在...");
        } else if (goods.getAmount() < nums) {
            //说明库存不足
            throw new NotEnoughException("编号为:"+goodsId+"商品库存不足...");
        }

        //能够进行到这里说明商品信息是合法的，可以更新库存
        Goods good = new Goods();
        good.setId(goodsId);
        good.setAmount(nums);
        goodsMapper.updateGoods(good);

        System.out.println("buy结束...");
    }
}