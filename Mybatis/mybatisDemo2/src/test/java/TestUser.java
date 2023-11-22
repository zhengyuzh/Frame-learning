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
         * 采用结果集映射后
         *
         * [com.zyz.mybatis.mapper.UserMapper.getUsers]-==>  Preparing: select * from user
         * [com.zyz.mybatis.mapper.UserMapper.getUsers]-==> Parameters:
         * [com.zyz.mybatis.mapper.UserMapper.getUsers]-<==      Total: 7
         * User{id=1, name='张三', password='123'}
         * User{id=2, name='李四', password='456'}
         * User{id=3, name='王五', password='789'}
         * User{id=4, name='麻子', password='321'}
         * User{id=5, name='李白', password='654'}
         * User{id=6, name='小明', password='987'}
         * User{id=7, name='小红', password='666'}
         *
         *
         **/
    }

    /**
     * @description: 查询 通过ID
     * @author: zhengyuzhu
     * @date: 2023/11/22 15:15
     **/
    @Test
    public void testDemo2(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);//查询

        System.out.println(user);
        sqlSession.close();

        /**
         * 输出如下：
         *
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-==>  Preparing: select * from user where id=?
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-==> Parameters: 1(Integer)
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-<==      Total: 1
         * User{id=1, name='张三', password='null'}
         *
         * 复用结果集映射
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-==>  Preparing: select * from user where id=?
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-==> Parameters: 1(Integer)
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-<==      Total: 1
         * User{id=1, name='张三', password='123'}
         *
         **/
    }

    /**
     * @description: 添加用户
     * @author: zhengyuzhu
     * @date: 2023/11/22 15:15
     **/
    @Test
    public void testDemo3(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(8);
        user.setName("小青");
        user.setPassword("888");
        mapper.addUser(user);//添加
        User userRs = mapper.getUserById(8);
        System.out.println("新添加用户 : " + userRs);
        sqlSession.close();

        /**
         * 输出如下：
         *
         * [com.zyz.mybatis.mapper.UserMapper.addUser]-==>  Preparing: insert into user (id,name,pwd) values(?,?,?)
         * [com.zyz.mybatis.mapper.UserMapper.addUser]-==> Parameters: 8(Integer), 小青(String), 888(String)
         * [com.zyz.mybatis.mapper.UserMapper.addUser]-<==    Updates: 1
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-==>  Preparing: select * from user where id=?
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-==> Parameters: 8(Integer)
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-<==      Total: 1
         * 新添加用户 : User{id=8, name='小青', password='888'}
         *
         **/
    }

    /**
     * @description: 修改用户
     * @author: zhengyuzhu
     * @date: 2023/11/22 15:15
     **/
    @Test
    public void testDemo4(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userRs = mapper.getUserById(8);
        System.out.println("未修改前用户信息 : " + userRs);

        User user = new User();
        user.setId(8);
        user.setName("小紫");
        user.setPassword("999");
        mapper.updateUser(user);//修改

        User userRss = mapper.getUserById(8);
        System.out.println("修改后用户信息 : " + userRss);

        sqlSession.close();

        /**
         * 输出如下：
         *
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-==>  Preparing: select * from user where id=?
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-==> Parameters: 8(Integer)
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-<==      Total: 1
         * 未修改前用户信息 : User{id=8, name='小青', password='888'}
         * [com.zyz.mybatis.mapper.UserMapper.updateUser]-==>  Preparing: update user set name=?,pwd=? where id=?
         * [com.zyz.mybatis.mapper.UserMapper.updateUser]-==> Parameters: 小紫(String), 999(String), 8(Integer)
         * [com.zyz.mybatis.mapper.UserMapper.updateUser]-<==    Updates: 1
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-==>  Preparing: select * from user where id=?
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-==> Parameters: 8(Integer)
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-<==      Total: 1
         * 修改后用户信息 : User{id=8, name='小紫', password='999'}
         *
         **/
    }

    /**
     * @description: 删除用户
     * @author: zhengyuzhu
     * @date: 2023/11/22 15:15
     **/
    @Test
    public void testDemo5(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User userRs = mapper.getUserById(8);
        System.out.println("删除前用户信息 : " + userRs);

        mapper.deleteUser(8);//删除

        User userRss = mapper.getUserById(8);
        System.out.println("删除后用户信息 : " + userRss);

        sqlSession.close();

        /**
         * 输出如下：
         *
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-==>  Preparing: select * from user where id=?
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-==> Parameters: 8(Integer)
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-<==      Total: 1
         * 删除前用户信息 : User{id=8, name='小紫', password='999'}
         * [com.zyz.mybatis.mapper.UserMapper.deleteUser]-==>  Preparing: delete from user where id = ?
         * [com.zyz.mybatis.mapper.UserMapper.deleteUser]-==> Parameters: 8(Integer)
         * [com.zyz.mybatis.mapper.UserMapper.deleteUser]-<==    Updates: 1
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-==>  Preparing: select * from user where id=?
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-==> Parameters: 8(Integer)
         * [com.zyz.mybatis.mapper.UserMapper.getUserById]-<==      Total: 0
         * 删除后用户信息 : null
         *
         **/
    }
}
