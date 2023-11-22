import com.zyz.mybatis.entity.Goods;
import com.zyz.mybatis.mapper.GoodsMapper;
import com.zyz.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;


/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: PACKAGE_NAME
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-22  09:19
 * @Description: TODO
 * @Version: 1.0
 */
public class TestGoods {
    static Logger logger = Logger.getLogger(TestGoods.class);
    /**
     * @description: 测试查询商品信息 数据库字段 和 实体类字段不一致问题
     * @author: zhengyuzhu
     * @date: 2023/11/22 9:19
     **/
    @Test
    public void testDemo1(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        Goods goods = goodsMapper.queryGoodsById(1001);
        System.out.println(goods);

        //关闭SqlSession
        sqlSession.close();

        /**
         *  输出如下 :
         *          实体类字段           数据库字段
         *             id                 id
         *         goods_Name            name
         *         goods_Amount         amount
         *         goods_Price           price
         *
         *  Goods{id=1001, goods_Name='null', goods_Amount=null, goods_Price=null}
         *
         *
         *
         *  第一种方式：字段起别名：
         *            select id,name as goods_Name,amount as goods_Amount,price as goods_Price
         *
         *  Goods{id=1001, goods_Name='茶杯', goods_Amount=10, goods_Price=13.6}
         *
         *
         *  第二种方式：结果集映射：
         *              具体实现查看 GoodsMapper.xml 文件注释描述
         *
         *  Goods{id=1001, goods_Name='茶杯', goods_Amount=10, goods_Price=13.6}
         *
         **/
    }

    /**
     * @description: 测试日志打印
     * @author: zhengyuzhu
     * @date: 2023/11/22 10:03
     **/
    @Test
    public void testDemo2(){
        logger.info("INFO   日志测试");
        logger.debug("DEBUG 日志测试");
        logger.error("ERROR 日志测试");
    }
}
