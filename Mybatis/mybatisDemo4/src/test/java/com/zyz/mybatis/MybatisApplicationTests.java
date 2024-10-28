package com.zyz.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zyz.mybatis.entity.GoodTwo;
import com.zyz.mybatis.entity.GoodsThree;
import com.zyz.mybatis.mapper.GoodTwoDao;
import com.zyz.mybatis.mapper.GoodsDao;
import com.zyz.mybatis.entity.Goods;
import com.zyz.mybatis.mapper.GoodsThreeDao;
import com.zyz.mybatis.mapper.UserInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    GoodsDao goodsDao;

    @Autowired
    GoodTwoDao goodTwoDao;

    @Autowired
    GoodsThreeDao goodsThreeDaoDao;

    @Test
    void contextLoads() {
        System.out.println(userInfoMapper.findAllUser());

    }

    /**
     * @description: 实体类字段和数据库字段一致情况。查询返回所有实体
     * @author: zhengyuzhu
     * @date: 2024/10/28 10:00
     **/
    @Test
    void testQuery(){
        LambdaQueryWrapper<Goods> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Goods::getId, "1001");
        List<Goods> goodsList = goodsDao.selectList(queryWrapper);
        goodsList.forEach(item->{
            System.out.println(item);
        });

        /**
         * @description: 测试结果
         *
         * ==>  Preparing: SELECT id,amount,price,name FROM goods WHERE (id = ?)
         * ==> Parameters: 1001(String)
         * <==    Columns: id, amount, price, name
         * <==        Row: 1001, 10, 13.60, 茶杯
         * <==      Total: 1
         * Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@4baed682]
         * Goods(id=1001, name=茶杯, amount=10, price=13.6)
         *
         *
         **/

    }

    /**
     * @description: 实体类字段缺少情况。查询返回部分实体
     * @author: zhengyuzhu
     * @date: 2024/10/28 9:59
     **/
    @Test
    void testQuery2(){
        LambdaQueryWrapper<GoodTwo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(GoodTwo::getId, "1001");
        List<GoodTwo> goodTwoList = goodTwoDao.selectList(queryWrapper);
        goodTwoList.forEach(item->{
            System.out.println(item);
        });

        /**
         * @description: 测试结果
         *
         * ==>  Preparing: SELECT id,name FROM goods WHERE (id = ?)
         * ==> Parameters: 1001(String)
         * <==    Columns: id, name
         * <==        Row: 1001, 茶杯
         * <==      Total: 1
         * Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@3664f108]
         * GoodTwo(id=1001, name=茶杯)
         *
         *
         **/

    }

    /**
     * @description: 实体类字段多 ，查询报错，显示数据库不存在相关字段
     * @author: zhengyuzhu
     * @date: 2024/10/28 10:07
     **/
    @Test
    void testQuery3(){
        LambdaQueryWrapper<GoodsThree> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(GoodsThree::getId, "1001");
        List<GoodsThree> goodsThreeList = goodsThreeDaoDao.selectList(queryWrapper);
        goodsThreeList.forEach(item->{
            System.out.println(item);
        });

        /**
         * @description: 测试结果
         *
         *
         * ### Error querying database.  Cause: com.mysql.jdbc.exceptions.MySQLSyntaxErrorException: Unknown column 'address' in 'field list'
         * ### The error may exist in com/zyz/mybatis/mapper/GoodsThreeDao.java (best guess)
         * ### The error may involve defaultParameterMap
         * ### The error occurred while setting parameters
         * ### SQL: SELECT  id,amount,address,price,name  FROM goods     WHERE (id = ?)
         * ### Cause: com.mysql.jdbc.exceptions.MySQLSyntaxErrorException: Unknown column 'address' in 'field list'
         * ; bad SQL grammar []; nested exception is com.mysql.jdbc.exceptions.MySQLSyntaxErrorException: Unknown column 'address' in 'field list'
         *
         *
         **/

    }

}
