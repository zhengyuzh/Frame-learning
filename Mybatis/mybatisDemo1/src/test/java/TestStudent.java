import com.zyz.mybatis.entity.Student;
import com.zyz.mybatis.mapper.StudentMapper;
import com.zyz.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: PACKAGE_NAME
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-20  16:52
 * @Description: 测试类  测试Student 增删改查
 * @Version: 1.0
 */
public class TestStudent {


    /**
     * @description: 基本测试
     * @author: zhengyuzhu
     * @date: 2023/11/20 22:21
     **/
    @Test
    public void test01(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> userList = studentMapper.queryAll();

        for (Student student : userList) {
            System.out.println(student);
        }

        //关闭SqlSession
        sqlSession.close();

        /**
         *      输出如下 :
         *
         * Student{stuNo=1, stuName='张三', cardID=1115, classID=1}
         * Student{stuNo=2, stuName='李四', cardID=1116, classID=2}
         * Student{stuNo=3, stuName='王五', cardID=1117, classID=3}
         *
         **/

    }

    /**
     * @description: 修改对象信息 通过Map
     * @author: zhengyuzhu
     * @date: 2023/11/20 23:02
     **/
    @Test
    public void test02(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String, Object> stuMap = new HashMap<>();
        stuMap.put("stuNo",1);
        stuMap.put("stuName","李白");
        stuMap.put("cardid",6);
        stuMap.put("classid",6);
        Integer rs = studentMapper.updateStudentMap(stuMap);
        Student student = studentMapper.queryStudentById(1);
        System.out.println(student);


        //关闭SqlSession
        sqlSession.close();

        /**
         *      输出如下 :
         *
         * Student{stuNo=1, stuName='张三', cardID=1115, classID=1}
         * Student{stuNo=2, stuName='李四', cardID=1116, classID=2}
         * Student{stuNo=3, stuName='王五', cardID=1117, classID=3}
         *
         **/

    }

    /**
     * @description: 修改对象信息 通过 Student 对象
     * @author: zhengyuzhu
     * @date: 2023/11/20 23:02
     **/
    @Test
    public void test03(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student studentBefore = studentMapper.queryStudentById(0);
        System.out.println("修改前的学生信息 : " + studentBefore);

        Student student = new Student();
        student.setStuNo(0);
        student.setStuName("麻子嘞");
        student.setClassID(6);
        student.setCardID(6);
        studentMapper.updateStudent(student);
        sqlSession.commit();//将数据保存到数据库

        Student studentAfter = studentMapper.queryStudentById(0);
        System.out.println("修改后的学生信息 : " + studentAfter);

        //关闭SqlSession
        sqlSession.close();

        /**
         *      输出如下 :
         *
         *  修改前的学生信息 : Student{stuNo=0, stuName='李四', cardID=8, classID=8}
         *  修改后的学生信息 : Student{stuNo=0, stuName='麻子嘞', cardID=6, classID=6}
         *
         **/

    }

    /**
     * @description: 添加对象
     * @author: zhengyuzhu
     * @date: 2023/11/21 21:06
     **/
    @Test
    public void test04(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setStuNo(9);
        student.setStuName("武松");
        student.setClassID(8);
        student.setCardID(8);
        studentMapper.addStudent(student);
        sqlSession.commit();//将数据保存到数据库
        Student studentRs = studentMapper.queryStudentById(9);
        System.out.println(studentRs);


        //关闭SqlSession
        sqlSession.close();

        /**
         *      输出如下 :
         *      Student{stuNo=9, stuName='武松', cardID=8, classID=8}
         *
         **/

    }

    /**
     * @description: 删除对象
     * @author: zhengyuzhu
     * @date: 2023/11/21 21:07
     **/
    @Test
    public void test05(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        studentMapper.deleteStudentById(9);
        sqlSession.commit();//将数据保存到数据库
        Student studentRs = studentMapper.queryStudentById(9);
        System.out.println(studentRs);

        //关闭SqlSession
        sqlSession.close();

        /**
         *      输出如下 :
         *      null
         *
         **/

    }


    /**
     * @description: 模糊查询
     * @author: zhengyuzhu
     * @date: 2023/11/21 21:41
     **/
    @Test
    public void test06(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> userList = studentMapper.getStudentLike("%李%");

        for (Student student : userList) {
            System.out.println(student);
        }

        //关闭SqlSession
        sqlSession.close();

        /**
         *      输出如下 :
         *
         * Student{stuNo=2, stuName='李四', cardID=1116, classID=2}
         * Student{stuNo=8, stuName='李老头', cardID=8, classID=8}
         *
         **/

    }


}
