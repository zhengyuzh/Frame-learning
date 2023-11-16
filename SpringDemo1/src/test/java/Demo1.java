import com.zyz.SpringDemo1.entity.Person;
import com.zyz.SpringDemo1.entity.School;
import com.zyz.SpringDemo1.entity.Student;
import com.zyz.SpringDemo1.entity.UniversityStudent;
import com.zyz.SpringDemo1.service.PersonService;
import com.zyz.SpringDemo1.service.UserService;
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

    /**
     * 注入的方式 set方式 注入属性测试
     *  属性的值赋予 集合类
     */
    @Test
    public void TestDemo6() {
        String config = "UniversityStudentBean.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        UniversityStudent universityStudent = (UniversityStudent) ac.getBean("universityStudent");
        System.out.println(universityStudent);
        /**
         * UniversityStudent{name='张三',
         *                   courses=[C语言, Go语言, Java语言],
         *                   fruitList=[🍎苹果, 🍑桃子, 🍇葡萄],
         *                   sportMaps={basketball=篮球, football=足球, badminton=羽毛球},
         *                   hobbySets=[读书, 敲代码, 听音乐]
         *                  }
         */

    }

    /**
     * 注入的方式 set方式 注入属性测试
     *  属性的值赋予 属性是外部Bean 外部对象
     */
    @Test
    public void TestDemo7() {
        String config = "StudentAndAddress.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("student");
        System.out.println(student);
        // 输出结果：Student{name='张三', age=18, address=Address{province='河南', city='郑州'}}

    }


    /**
     * 注入的方式 set方式 注入属性测试
     *  属性的值赋予 内部Bean 外部对象
     */
    @Test
    public void TestDemo8() {
        String config = "StudentAndAddress.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("student2");
        System.out.println(student);
        //输出结果：Student{name='李四', age=23, address=Address{province='广东', city='广州'}}

    }

    /**
     * 注入的方式 set方式 注入属性测试
     *  属性的值赋予 内部Bean 外部对象
     */
    @Test
    public void TestDemo9() {
        String config = "SchoolBean.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        School school = (School) ac.getBean("school");
        System.out.println(school);
        //构造参数按照顺序 输出结果：School{name='国防科技大学', address='Address{province='湖南', city='长沙'}', hisotry=70}

        School school2 = (School) ac.getBean("school2");
        System.out.println(school2);
        //构造参数不按照顺序 输出结果：School{name='国防科技大学', address='Address{province='湖南', city='长沙'}', hisotry=70}

        School school3 = (School) ac.getBean("school3");
        System.out.println(school3);
        //构造参数按照下标 输出结果：School{name='国防科技大学', address='Address{province='湖南', city='长沙'}', hisotry=70}
    }

    /**
     * 注入的方式 set方式 注入属性测试
     *  属性的值赋予 自动装配   byType  bean对象设置成 autowire="byName"  配置文件中寻找和实体类中对应类对象一样的 值
     */
    @Test
    public void TestDemo10() {
        String config = "AutomaticAssemblyBean.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("student");
        System.out.println(student);
        //输出结果：Student{name='张三', age=18, address=Address{province='河南', city='郑州'}}

    }

    /**
     * 注入的方式 set方式 注入属性测试
     *  属性的值赋予 自动装配  byType  bean对象设置成 autowire="byType" 会在配置文件中，寻找该类型的对象
     *  如果要测试这一部分 ，需要放开 AutomaticAssemblyBean.xml 配置文件中的 byType ，同时注释掉其它的地址对象。只留下一个，才可以正确匹配
     */
    @Test
    public void TestDemo11() {
        String config = "AutomaticAssemblyBean.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student2 = (Student) ac.getBean("student2");
        System.out.println(student2);
        //输出结果： Student{name='李四', age=24, address=Address{province='河南', city='郑州'}}

    }


    /**
     * @description:   在注解里面 value 属性值可以省略不写
     *                 默认值是类名称，首字母小写
     *                 UserService -- userService
     * @author: zhengyuzhu
     * @date: 2023/11/16 8:35
     **/
    @Test
    public void testDemo2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AnnotationDevelopment.xml");
        UserService userService1 = context.getBean("userService", UserService.class);
        userService1.say();
        //输出结果：UserDaoImpl showTime ......
        //        UserService say .......

    }


    /**
     * @description: @Qualifier("userDaoImplTwo")  @Repository("userDaoImplTwo") //起个名称
     *               当一个类型 有多个对象的时候。这个时候通过类型自动装配。需要 让 @Autowired 和 @Qualifier
     *               配合使用。同时需要指定对象的名称 动态代理
     * @author: zhengyuzhu
     * @date: 2023/11/16 9:04
     **/
    @Test
    public void testDemo13(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AnnotationDevelopment.xml");
        UserService userService1 = context.getBean("userService", UserService.class);
        userService1.say();
        //输出结果：UserDaoImplTwo showTime ......
        //        UserService say .......

    }

    /**
     * @description: 给属性赋值，不常用
     * @author: zhengyuzhu
     * @date: 2023/11/16 9:04
     **/
    @Test
    public void testDemo14(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AnnotationDevelopment.xml");
        UserService userService1 = context.getBean("userService", UserService.class);
        userService1.say();
        //输出结果：UserDaoImplTwo showTime ......
        //        UserService say .......姓名: 张三,性别: 男

    }


}
