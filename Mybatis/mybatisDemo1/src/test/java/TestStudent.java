import com.zyz.mybatis.entity.Student;
import com.zyz.mybatis.mapper.StudentMapper;
import com.zyz.mybatis.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
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

    /**
     * @description: 测试缓存 拿缓存数据 同一个session 连续查询两次
     * @author: zhengyuzhu
     * @date: 2023/11/23 15:02
     **/
    @Test
    public void test07(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.queryStudentById(1);

        System.out.println(student);
        System.out.println("-----------------");
        Student student1 = studentMapper.queryStudentById(1);
        System.out.println(student1);
        System.out.println("是否是同一个对象:" + (student1 == student));

        //关闭SqlSession
        sqlSession.close();

        /**
         *      只进行了一次查询 输出如下 :
         *
         * [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 341748265.
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Setting autocommit to false on JDBC Connection [com.mysql.jdbc.JDBC4Connection@145eaa29]
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==>  Preparing: select * from student where stuNo = ?
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==> Parameters: 1(Integer)
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-<==      Total: 1
         * Student{stuNo=1, stuName='张三', cardID=1115, classID=1}
         * -----------------
         * Student{stuNo=1, stuName='张三', cardID=1115, classID=1}
         * 是否是同一个对象:true
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Resetting autocommit to true on JDBC Connection [com.mysql.jdbc.JDBC4Connection@145eaa29]
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@145eaa29]
         *
         **/

    }

    /**
     * @description:  测试缓存失效的情况  1、进行不同的数据查询
     * @author: zhengyuzhu
     * @date: 2023/11/23 15:02
     **/
    @Test
    public void test08(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.queryStudentById(1);

        System.out.println(student);
        System.out.println("-----------------");
        Student student1 = studentMapper.queryStudentById(2);
        System.out.println(student1);

        //关闭SqlSession
        sqlSession.close();

        /**
         *   1、查询不同的数据的时候，缓存会失效
         *
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Opening JDBC Connection
         * [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 341748265.
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Setting autocommit to false on JDBC Connection [com.mysql.jdbc.JDBC4Connection@145eaa29]
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==>  Preparing: select * from student where stuNo = ?
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==> Parameters: 1(Integer)
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-<==      Total: 1
         * Student{stuNo=1, stuName='张三', cardID=1115, classID=1}
         * -----------------
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==>  Preparing: select * from student where stuNo = ?
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==> Parameters: 2(Integer)
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-<==      Total: 1
         * Student{stuNo=2, stuName='李四', cardID=1116, classID=2}
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Resetting autocommit to true on JDBC Connection [com.mysql.jdbc.JDBC4Connection@145eaa29]
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@145eaa29]
         *
         **/

    }

    /**
     * @description:  测试缓存失效的情况  2、进行了删除或者修改操作
     * @author: zhengyuzhu
     * @date: 2023/11/23 15:02
     **/
    @Test
    public void test09(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student1 = studentMapper.queryStudentById(1);

        System.out.println("修改前数据：" + student1);
        System.out.println("-----------------");

        Student student = new Student();
        student.setStuNo(1);
        student.setStuName("张麻子666");
        student.setClassID(8);
        student.setCardID(8);
        studentMapper.updateStudent(student); //修改
        System.out.println("-----------------");

        Student student2 = studentMapper.queryStudentById(1);
        System.out.println("修改后数据：" + student2);

        //关闭SqlSession
        sqlSession.close();

        /**
         *   1、查询相同的数据，但是中间进行了修改操作
         *
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Opening JDBC Connection
         * [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 341748265.
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Setting autocommit to false on JDBC Connection [com.mysql.jdbc.JDBC4Connection@145eaa29]
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==>  Preparing: select * from student where stuNo = ?
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==> Parameters: 1(Integer)
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-<==      Total: 1
         * 修改前数据：Student{stuNo=1, stuName='张三', cardID=1115, classID=1}
         * -----------------
         * [com.zyz.mybatis.mapper.StudentMapper.updateStudent]-==>  Preparing: update student set stuNo = ?, stuName = ?, cardid = ?, classid = ? where stuNo = ?
         * [com.zyz.mybatis.mapper.StudentMapper.updateStudent]-==> Parameters: 1(Integer), 张麻子666(String), 8(Integer), 8(Integer), 1(Integer)
         * [com.zyz.mybatis.mapper.StudentMapper.updateStudent]-<==    Updates: 1
         * -----------------
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==>  Preparing: select * from student where stuNo = ?
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==> Parameters: 1(Integer)
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-<==      Total: 1
         * 修改后数据：Student{stuNo=1, stuName='张麻子666', cardID=8, classID=8}
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Rolling back JDBC Connection [com.mysql.jdbc.JDBC4Connection@145eaa29]
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Resetting autocommit to true on JDBC Connection [com.mysql.jdbc.JDBC4Connection@145eaa29]
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@145eaa29]
         *
         **/

    }


    /**
     * @description: 手动清除缓存 缓存失效。查询两次
     * @author: zhengyuzhu
     * @date: 2023/11/23 15:21
     **/
    @Test
    public void test10(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.queryStudentById(1);

        System.out.println(student);
        System.out.println("-----------------");
        sqlSession.clearCache(); //手动清除缓存
        Student student1 = studentMapper.queryStudentById(1);
        System.out.println(student1);

        //关闭SqlSession
        sqlSession.close();

        /**
         *   1、同一个连接，连续两次查询。第二次查询拿缓存数据
         *
         * [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 341748265.
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Setting autocommit to false on JDBC Connection [com.mysql.jdbc.JDBC4Connection@145eaa29]
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==>  Preparing: select * from student where stuNo = ?
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==> Parameters: 1(Integer)
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-<==      Total: 1
         * Student{stuNo=1, stuName='张三', cardID=1115, classID=1}
         * -----------------
         * Student{stuNo=1, stuName='张三', cardID=1115, classID=1}
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Resetting autocommit to true on JDBC Connection [com.mysql.jdbc.JDBC4Connection@145eaa29]
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@145eaa29]
         *
         *
         *
         * 2、手动清除缓存
         *
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Opening JDBC Connection
         * [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 341748265.
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Setting autocommit to false on JDBC Connection [com.mysql.jdbc.JDBC4Connection@145eaa29]
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==>  Preparing: select * from student where stuNo = ?
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==> Parameters: 1(Integer)
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-<==      Total: 1
         * Student{stuNo=1, stuName='张三', cardID=1115, classID=1}
         * -----------------
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==>  Preparing: select * from student where stuNo = ?
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==> Parameters: 1(Integer)
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-<==      Total: 1
         * Student{stuNo=1, stuName='张三', cardID=1115, classID=1}
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Resetting autocommit to true on JDBC Connection [com.mysql.jdbc.JDBC4Connection@145eaa29]
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@145eaa29]
         *
         **/

    }

    /**
     * @description: 二级缓存 创建两个sqlSession
     * @author: zhengyuzhu
     * @date: 2023/11/23 15:51
     **/
    @Test
    public void test11(){
        SqlSessionFactory sqlSessionFactory = null;
        try {
            //使用Mybatis第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //第一步：获得SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //方式一：getMapper
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student1 = studentMapper.queryStudentById(1);

        System.out.println("第1次查询：" + student1);
        Student student2 = studentMapper.queryStudentById(1);
        System.out.println("第2次查询：" + student2);
        // 效果：查出的数据首先放在一级缓存中，只有一级缓存被关闭或者提交以后，
        //      一级缓存数据才会转移到二级缓存
        sqlSession.commit();


        System.out.println("二级缓存观测点");
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);

        Student student3 = studentMapper2.queryStudentById(1);

        System.out.println("第一次执行:"+ student3);
        Student student4 = studentMapper2.queryStudentById(1);
        System.out.println("第2次执行:"+ student4);
        sqlSession2.commit();
        System.out.println("四个对象是否相同：" + ((student1 == student2) && (student3 == student4) &&(student1 == student4)));

        //关闭SqlSession
        sqlSession.close();
        sqlSession2.close();
        /**
         *   二级缓存开启
         *
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Opening JDBC Connection
         * [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 921760190.
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Setting autocommit to false on JDBC Connection [com.mysql.jdbc.JDBC4Connection@36f0f1be]
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==>  Preparing: select * from student where stuNo = ?
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-==> Parameters: 1(Integer)
         * [com.zyz.mybatis.mapper.StudentMapper.queryStudentById]-<==      Total: 1
         * 第1次查询：Student{stuNo=1, stuName='张三', cardID=1115, classID=1}
         * [com.zyz.mybatis.mapper.StudentMapper]-Cache Hit Ratio [com.zyz.mybatis.mapper.StudentMapper]: 0.0
         * 第2次查询：Student{stuNo=1, stuName='张三', cardID=1115, classID=1}
         * 二级缓存观测点
         * [com.zyz.mybatis.mapper.StudentMapper]-Cache Hit Ratio [com.zyz.mybatis.mapper.StudentMapper]: 0.3333333333333333
         * 第一次执行:Student{stuNo=1, stuName='张三', cardID=1115, classID=1}
         * [com.zyz.mybatis.mapper.StudentMapper]-Cache Hit Ratio [com.zyz.mybatis.mapper.StudentMapper]: 0.5
         * 第2次执行:Student{stuNo=1, stuName='张三', cardID=1115, classID=1}
         * 四个对象是否相同：true
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Resetting autocommit to true on JDBC Connection [com.mysql.jdbc.JDBC4Connection@36f0f1be]
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@36f0f1be]
         **/

    }

}
