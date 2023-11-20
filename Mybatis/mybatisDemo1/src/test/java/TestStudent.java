import com.zyz.mybatis.entity.Student;
import com.zyz.mybatis.mapper.StudentMapper;
import com.zyz.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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


}
