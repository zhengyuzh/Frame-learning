import com.zyz.SpringDemo1.entity.Person;
import com.zyz.SpringDemo1.service.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
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

    /**
     * 使用spring容器创建对象
     */
    @Test
    public void TestDemo1(){
        //1、指定spring配置文件的名称
        String config = "personBean.xml";
        //2、创建表示spring容器的对象 ApplicationContext
        //ClassPathXmlApplicationContext：表示从类路径中加载spring配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //3、从容器中获取对象
        PersonService personService = (PersonService)ac.getBean("personService");
        //4、调用方法
        personService.doWork();
    }


    //获取spring容器中java对象的信息
    @Test
    public void TestDemo2() {
        String config = "personBean.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //获取spring容器中对象的个数
        int beansCount = ac.getBeanDefinitionCount();
        System.out.println("spring容器中的对象个数="+beansCount);
        //获取spring容器中对象的名称（即bean标签的id值）
        String[] beansNames = ac.getBeanDefinitionNames();
        for (String beanName : beansNames) {
            System.out.println(beanName);
        }
    }
}
