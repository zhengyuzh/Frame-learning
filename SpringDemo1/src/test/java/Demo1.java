import com.zyz.SpringDemo1.entity.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/8 14:05
 * @Description: 测试类
 */
public class Demo1 {

    /**
     *测试类
     */
    @Test
    public void TestDemo(){
        //1、加载spring配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        //2、获取配置创建的对象
        Person person = context.getBean("person", Person.class);
        person.setId(1);
        person.setName("张三");
        person.setAge("18");
        System.out.println(person);
        person.say();

    }
}
