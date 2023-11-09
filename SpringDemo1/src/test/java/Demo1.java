import com.zyz.SpringDemo1.entity.Person;
import com.zyz.SpringDemo1.entity.Student;
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


    /**
     * 注入的方式 set方式 注入属性测试
     */
    @Test
    public void TestDemo3() {
        String config = "StudentBean.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        Student student = (Student) ac.getBean("student");
        System.out.println(student);// 输出结果：Student{name='张三', age=18}

    }

    /**
     * 注入的方式 set方式 注入属性测试
     *  属性的值赋予空值 （null）
     */
    @Test
    public void TestDemo4() {
        String config = "StudentBean.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("student2");
        System.out.println(student); // 输出结果：Student{name='null', age=null}

    }

    /**
     * 注入的方式 set方式 注入属性测试
     *  属性的值赋予 特殊符号
     */
    @Test
    public void TestDemo5() {
        String config = "StudentBean.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("student3");
        System.out.println(student); // 输出结果：Student{name='<<王五>>', age=23}

    }

}
