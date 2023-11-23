import com.zyz.mybatis.entity.Student;
import com.zyz.mybatis.mapper.StudentMapper;
import com.zyz.mybatis.mapper.TeacherMapper;
import com.zyz.mybatis.utils.MybatisUtils;
import com.zyz.mybatis.vo.TeacherT;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: PACKAGE_NAME
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-22  22:37
 * @Description: TODO
 * @Version: 1.0
 */
public class TestStudent {

    /**
     * @description: 1、按照结果集嵌套处理  多对一
     * @author: zhengyuzhu
     * @date: 2023/11/22 23:07
     **/
    @Test
    public void testDemo1(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.getStudent();

        for(Student student : studentList){
            System.out.println(student);
        }

        sqlSession.close();

        /**
         * 输出如下：
         *
         * [com.zyz.mybatis.mapper.StudentMapper.getStudent]-==>  Preparing: select s.id sid,s.name sname,t.name tname,s.tid tid from tb_student s join tb_teacher t on s.tid = t.id
         * [com.zyz.mybatis.mapper.StudentMapper.getStudent]-==> Parameters:
         * [com.zyz.mybatis.mapper.StudentMapper.getStudent]-<==      Total: 8
         * Student{id=1, name='唐三', teacher=Teacher{id=1, name='玉小刚'}}
         * Student{id=2, name='小舞', teacher=Teacher{id=1, name='玉小刚'}}
         * Student{id=3, name='戴沐白', teacher=Teacher{id=1, name='玉小刚'}}
         * Student{id=4, name='朱朱清', teacher=Teacher{id=1, name='玉小刚'}}
         * Student{id=5, name='奥斯卡', teacher=Teacher{id=1, name='玉小刚'}}
         * Student{id=6, name='宁荣荣', teacher=Teacher{id=1, name='玉小刚'}}
         * Student{id=7, name='马红俊', teacher=Teacher{id=1, name='玉小刚'}}
         * Student{id=8, name='白尘香', teacher=Teacher{id=1, name='玉小刚'}}
         *
         **/
    }


    /**
     * @description: 2、 按照查询嵌套处理  多对一
     * @author: zhengyuzhu
     * @date: 2023/11/22 23:07
     **/
    @Test
    public void testDemo2(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.getStudent2();

        for(Student student : studentList){
            System.out.println(student);
        }

        sqlSession.close();

        /**
         * 输出如下：
         *
         * [com.zyz.mybatis.mapper.StudentMapper.getStudent2]-==>  Preparing: select * from tb_student;
         * [com.zyz.mybatis.mapper.StudentMapper.getStudent2]-==> Parameters:
         * [com.zyz.mybatis.mapper.StudentMapper.getTeacher]-====>  Preparing: select * from tb_teacher where id = ?;
         * [com.zyz.mybatis.mapper.StudentMapper.getTeacher]-====> Parameters: 1(Integer)
         * [com.zyz.mybatis.mapper.StudentMapper.getTeacher]-<====      Total: 1
         * [com.zyz.mybatis.mapper.StudentMapper.getStudent2]-<==      Total: 8
         * Student{id=1, name='唐三', teacher=Teacher{id=1, name='玉小刚'}}
         * Student{id=2, name='小舞', teacher=Teacher{id=1, name='玉小刚'}}
         * Student{id=3, name='戴沐白', teacher=Teacher{id=1, name='玉小刚'}}
         * Student{id=4, name='朱朱清', teacher=Teacher{id=1, name='玉小刚'}}
         * Student{id=5, name='奥斯卡', teacher=Teacher{id=1, name='玉小刚'}}
         * Student{id=6, name='宁荣荣', teacher=Teacher{id=1, name='玉小刚'}}
         * Student{id=7, name='马红俊', teacher=Teacher{id=1, name='玉小刚'}}
         * Student{id=8, name='白尘香', teacher=Teacher{id=1, name='玉小刚'}}
         *
         **/
    }

    /**
     * @description: 1、 按结果嵌套查询  一对多
     * @author: zhengyuzhu
     * @date: 2023/11/22 23:07
     **/
    @Test
    public void testDemo3(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        TeacherT teacher = teacherMapper.getTeacherById(1);

        System.out.println(teacher);

        sqlSession.close();

        /**
         * 输出如下：
         *
         [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 1486566962.
         [com.zyz.mybatis.mapper.TeacherMapper.getTeacherById]-==>  Preparing: select t.id id, t.name tname, s.id sid,s.name sname,s.tid tid from tb_teacher t join tb_student s on t.id = s.tid;
         [com.zyz.mybatis.mapper.TeacherMapper.getTeacherById]-==> Parameters:
         [com.zyz.mybatis.mapper.TeacherMapper.getTeacherById]-<==      Total: 8
         TeacherT(id=1, name=玉小刚, studentTs=[
                                               StudentT(id=1, name=唐三, tid=1),
                                               StudentT(id=2, name=小舞, tid=1),
                                               StudentT(id=3, name=戴沐白, tid=1),
                                               StudentT(id=4, name=朱朱清, tid=1),
                                               StudentT(id=5, name=奥斯卡, tid=1),
                                               StudentT(id=6, name=宁荣荣, tid=1),
                                               StudentT(id=7, name=马红俊, tid=1),
                                               StudentT(id=8, name=白尘香, tid=1)
                                               ])
         [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@589b3632]
         *
         **/
    }

    /**
     * @description: 2、 按照查询嵌套处理  一对多
     * @author: zhengyuzhu
     * @date: 2023/11/22 23:07
     **/
    @Test
    public void testDemo4(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        TeacherT teacher = teacherMapper.getTeacher2(1);

        System.out.println(teacher);

        sqlSession.close();

        /**
         * 输出如下：
         *
         [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 1486566962.
         [com.zyz.mybatis.mapper.TeacherMapper.getTeacher2]-==>  Preparing: select * from tb_teacher where id = ?
         [com.zyz.mybatis.mapper.TeacherMapper.getTeacher2]-==> Parameters: 1(Integer)
         [com.zyz.mybatis.mapper.TeacherMapper.getStudentByTeacherId]-====>  Preparing: select * from tb_student where tid = ?
         [com.zyz.mybatis.mapper.TeacherMapper.getStudentByTeacherId]-====> Parameters: 1(Integer)
         [com.zyz.mybatis.mapper.TeacherMapper.getStudentByTeacherId]-<====      Total: 8
         [com.zyz.mybatis.mapper.TeacherMapper.getTeacher2]-<==      Total: 1
         TeacherT(id=1, name=玉小刚, studentTs=[
                                               StudentT(id=1, name=唐三, tid=1),
                                               StudentT(id=2, name=小舞, tid=1),
                                               StudentT(id=3, name=戴沐白, tid=1),
                                               StudentT(id=4, name=朱朱清, tid=1),
                                               StudentT(id=5, name=奥斯卡, tid=1),
                                               StudentT(id=6, name=宁荣荣, tid=1),
                                               StudentT(id=7, name=马红俊, tid=1),
                                               StudentT(id=8, name=白尘香, tid=1)
                                               ])
         [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@589b3632]
         *
         **/
    }
}
