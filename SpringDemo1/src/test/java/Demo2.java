import com.zyz.SpringDemo1.config.ConfigAop;
import com.zyz.SpringDemo1.entity.Address;
import com.zyz.SpringDemo1.entity.Student;
import com.zyz.SpringDemo1.service.IService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: PACKAGE_NAME
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-16  21:33
 * @Description: TODO
 * @Version: 1.0
 */
public class Demo2 {

    //aop前置通知
    @Test
    public void test01() {
        String config = "AspectJBean.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //获取目标对象，此时的service就是spring生成的代理对象
        //注意返回值类型是接口类型，不能是实现类接口，否则报错
        IService service = ac.getBean("service",IService.class);
        //使用代理对象执行方法
        service.doSome("张三",23);

        // 输出结果：
        // 连接点方法的方法签名=void com.zyz.SpringDemo1.service.IService.doSome(String,int)
        // 连接点方法的方法名=doSome
        // arg=张三
        // arg=23
        // ===doSome()===
    }

    //aop后置通知
    @Test
    public void test02() {
        String config = "AspectJBean.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //获取目标对象，此时的service就是spring生成的代理对象
        //注意返回值类型是接口类型，不能是实现类接口，否则报错
        IService service = ac.getBean("service",IService.class);
        Address address = new Address();
        address.setCity("长沙");
        address.setProvince("湖南");
        Student student = new Student();
        student.setAge(18);
        student.setName("张三");
        student.setAddress(address);
        //使用代理对象执行方法
        service.doStudent(student);
        System.out.println(student);

        // 输出结果：
        // 连接点方法的方法签名=void com.zyz.SpringDemo1.service.IService.doSome(String,int)
        // 连接点方法的方法名=doSome
        // arg=张三
        // arg=23
        // ===doSome()===
    }

    //aop环绕通知
    @Test
    public void test03() {
        String config = "AspectJBean.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //获取目标对象，此时的service就是spring生成的代理对象
        //注意返回值类型是接口类型，不能是实现类接口，否则报错
        IService service = ac.getBean("service",IService.class);
        Address address = new Address();
        address.setCity("长沙");
        address.setProvince("湖南");
        Student student = new Student();
        student.setAge(18);
        student.setName("张三");
        student.setAddress(address);
        //使用代理对象执行方法
        Student student1 = service.doStudent(student);
        System.out.println(student1);

        // 输出结果：
        // 环绕通知在连接点方法之前执行了...
        // 事务已提交...
        // Student{name='李四', age=24, address=null}
        // ===查看是否改变了连接点方法的返回值===Student{name='李四', age=24, address=null}
        // Student{name='李四', age=24, address=null}
    }


    // 完全注解开发 添加配置类 。开启包扫描 及 aop 注解
    @Test
    public void test04(){
        //加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigAop.class);
        IService service = context.getBean("service",IService.class);
        service.doSome("张三",18);
        // 测试结果：
        // 连接点方法的方法签名=void com.zyz.SpringDemo1.service.impl.ServiceImpl.doSome(String,int)
        // 连接点方法的方法名=doSome
        // arg=张三
        // arg=18
        // ===doSome()===

    }

}
