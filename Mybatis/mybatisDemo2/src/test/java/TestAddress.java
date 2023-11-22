import com.zyz.mybatis.entity.Address;
import org.junit.Test;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: PACKAGE_NAME
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-22  16:56
 * @Description: TODO
 * @Version: 1.0
 */
public class TestAddress {
    /**
     * @description: 测试地址 lombok
     * @author: zhengyuzhu
     * @date: 2023/11/22 16:56
     **/
    @Test
    public void testDemo1(){
        Address address = new Address("天河","广州","广东省");
        System.out.println("Lombok通过构造函数生成对象: " + address);
        Address address1 = new Address();
        address1.setName("开福区");
        address1.setCity("长沙");
        address1.setProvince("湖南");
        System.out.println("Lombok通过 get/set 生成对象: " + address1);
        /**
         * 输出如下：
         *
         * Lombok通过构造函数生成对象: Address(name=天河, city=广州, province=广东省)
         * Lombok通过 get/set 生成对象: Address(name=开福区, city=长沙, province=湖南)
         *
         **/

    }
}
