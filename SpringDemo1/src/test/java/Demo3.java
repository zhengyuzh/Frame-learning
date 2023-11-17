import com.zyz.SpringDemo2.entity.Student;
import com.zyz.SpringDemo2.mapper.StudentMapper;
import com.zyz.SpringDemo2.service.IStudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: PACKAGE_NAME
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-16  22:44
 * @Description: TODO
 * @Version: 1.0
 */
public class Demo3 {

    //执行查询全部，不使用service
    @Test
    public void test02() {
        String config = "SpringApplication.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //获取mapper的代理对象
        StudentMapper mapper = (StudentMapper) ac.getBean("studentMapper");
        List<Student> students = mapper.queryAll();
        for (Student student : students) {
            System.out.println("student--->"+student);
        }
    }

    //执行增加学生，使用service
    @Test
    public void test03() {
        String config = "SpringApplication.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //获取service对象
        IStudentService service = (IStudentService) ac.getBean("studentServiceImpl");
        Student student = new Student();
        student.setStuName("呵呵");
        student.setStuNo(1111);
        student.setCardID(1115);
        student.setClassID(1);
        service.addStudent(student);

    }
}
