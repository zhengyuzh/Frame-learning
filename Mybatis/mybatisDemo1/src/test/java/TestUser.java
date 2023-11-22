import com.zyz.mybatis.entity.User;
import com.zyz.mybatis.mapper.UserMapper;
import com.zyz.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: PACKAGE_NAME
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-22  14:41
 * @Description: TODO
 * @Version: 1.0
 */
public class TestUser {

    /**
     * @description: 注解开发 查询
     * @author: zhengyuzhu
     * @date: 2023/11/22 14:41
     **/
    @Test
    public void testDemo1(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();

        /**
         * 输出如下：
         *
         * [com.zyz.mybatis.mapper.UserMapper.getUsers]-==>  Preparing: select * from user
         * [com.zyz.mybatis.mapper.UserMapper.getUsers]-==> Parameters:
         * [com.zyz.mybatis.mapper.UserMapper.getUsers]-<==      Total: 6
         * User{id=1, name='张三', password='null'}
         * User{id=2, name='李四', password='null'}
         * User{id=3, name='王五', password='null'}
         * User{id=4, name='麻子', password='null'}
         * User{id=5, name='李白', password='null'}
         * User{id=6, name='小明', password='null'}
         *
         *
         **/
    }
}
