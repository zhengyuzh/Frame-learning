import com.zyz.SpringDemo3.entity.Goods;
import com.zyz.SpringDemo3.service.IBuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: PACKAGE_NAME
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-17  22:12
 * @Description: TODO
 * @Version: 1.0
 */
public class Demo4 {

    //不使用事务测试
    @Test
    public void test01() {
        String config = "TransactionApplication.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //获取service对象
        IBuyGoodsService service = (IBuyGoodsService) ac.getBean("buyGoodsService");

        //商品编号不存在情况
        //java.lang.NullPointerException: 编号为:1003商品不存在...
        // service.buy(1006,50);
        //商品库存不足情况
        //com.mms.exception.NotEnoughException: 编号为:1002商品库存不足...
        service.buy(1002,100);
        //正常情况
        // service.buy(1002,2);
    }

    /**
     * @description: 根据商品ID 查询用户信息a/**************************************************************
     * @author: zhengyuzhu
     * @date: 2023/11/17 23:12
     **/
    @Test
    public void test02() {
        String config = "TransactionApplication.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //获取service对象
        IBuyGoodsService service = (IBuyGoodsService) ac.getBean("buyGoodsService");

        Integer goodsId = 1001;
        Goods goods = service.queryGoodsById(goodsId);
        System.out.println("查询商品编号为: " + goodsId + ",的商品信息: " + goods);
        //输出结果如下: 查询商品编号为: 1001,的商品信息: Goods{id=1001, name='茶杯', amount=10, price=13.6}
    }
}
