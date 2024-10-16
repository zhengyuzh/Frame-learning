package com.zyz.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zyz.mybatis.mapper.GoodsDao;
import com.zyz.mybatis.entity.Goods;
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

    @Test
    void contextLoads() {
        System.out.println(userInfoMapper.findAllUser());

    }

    @Test
    void testQuery(){
        LambdaQueryWrapper<Goods> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Goods::getId, "1001");
        List<Goods> goodsList = goodsDao.selectList(queryWrapper);
        goodsList.forEach(item->{
            System.out.println(item);
        });

    }

}
