import com.zyz.mybatis.entity.Blog;
import com.zyz.mybatis.entity.Student;
import com.zyz.mybatis.mapper.BlogMapper;
import com.zyz.mybatis.mapper.StudentMapper;
import com.zyz.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: PACKAGE_NAME
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-23  12:34
 * @Description: TODO
 * @Version: 1.0
 */
public class TestBlog {

    /**
     * @description: IF 测试
     * @author: zhengyuzhu
     * @date: 2023/11/23 12:46
     **/
    @Test
    public void testDemo1(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> blogMap = new HashMap<>();
        blogMap.put("title","张麻子娶亲");
        blogMap.put("author","张老头");

        Blog blog = blogMapper.queryBlogIF(blogMap);//查询

        System.out.println(blog);

        sqlSession.close();

        /**
         *
         *
         * blogMap.put("title","张麻子娶亲");
         * blogMap.put("author","张老头");
         *
         * 查询条件两个：输出如下：
         *
         * [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 846947180.
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIF]-==>  Preparing: select * from blog where 1=1 and title = ? and author = ?
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIF]-==> Parameters: 张麻子娶亲(String), 张老头(String)
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIF]-<==      Total: 1
         * Blog(id=1, title=张麻子娶亲, author=张老头, createTime=2023-11-23 00:00:00, views=30)
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@327b636c]
         *
         *
         * blogMap.put("title","张麻子娶亲");
         * 查询条件一个输出如下
         *
         * [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 1172131546.
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIF]-==>  Preparing: select * from blog where 1=1 and title = ?
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIF]-==> Parameters: 张麻子娶亲(String)
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIF]-<==      Total: 1
         * Blog(id=1, title=张麻子娶亲, author=张老头, createTime=2023-11-23 00:00:00, views=30)
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@45dd4eda]
         *
         *
         *
         *
          **/
    }

    /**
     * @description: choose 测试 when  otherwise
     * @author: zhengyuzhu
     * @date: 2023/11/23 13:34
     **/
    @Test
    public void testDemo2(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> blogMap = new HashMap<>();
        // blogMap.put("title","张麻子娶亲");
        // blogMap.put("author","张老头");
        blogMap.put("views",30);

        Blog blog = blogMapper.queryBlogChoose(blogMap);

        System.out.println(blog);

        sqlSession.close();

        /**
         *
         * 1、多个参数不会拼接，哪个有值 用哪个
         *
         * blogMap.put("title","张麻子娶亲");
         * blogMap.put("author","张老头");
         *
         * 查询条件两个 但是拼接的时候 第一个有值，就不会在拼接接下来的数据
         *
         * [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 846947180.
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogChoose]-==>  Preparing: select * from blog WHERE title = ?
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogChoose]-==> Parameters: 张麻子娶亲(String)
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogChoose]-<==      Total: 1
         * Blog(id=1, title=张麻子娶亲, author=张老头, createTime=2023-11-23 00:00:00, views=30)
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@327b636c]
         *
         *
         * blogMap.put("author","张老头");
         * 2、查询条件一个输出如下
         *
         [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 1172131546.
         [com.zyz.mybatis.mapper.BlogMapper.queryBlogChoose]-==>  Preparing: select * from blog WHERE author = ?
         [com.zyz.mybatis.mapper.BlogMapper.queryBlogChoose]-==> Parameters: 张老头(String)
         [com.zyz.mybatis.mapper.BlogMapper.queryBlogChoose]-<==      Total: 1
         Blog(id=1, title=张麻子娶亲, author=张老头, createTime=2023-11-23 00:00:00, views=30)
         [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@45dd4eda]
         *
         *
         *
         * 3、查询条件 一个 都不满足情况 otherwise
         * blogMap.put("views",30);
         *
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogChoose]-==>  Preparing: select * from blog WHERE views = ?
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogChoose]-==> Parameters: 30(Integer)
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogChoose]-<==      Total: 1
         * Blog(id=1, title=张麻子娶亲, author=张老头, createTime=2023-11-23 00:00:00, views=30)
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@45dd4eda]
         *
         **/
    }

    /**
     * @description: trim (where, set)的使用 查询
     * @author: zhengyuzhu
     * @date: 2023/11/23 13:36
     **/
    @Test
    public void testDemo3(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> blogMap = new HashMap<>();
        blogMap.put("title","张麻子娶亲");
        blogMap.put("author","张老头");

        Blog blog = blogMapper.queryBlogIFTwo(blogMap);//查询

        System.out.println(blog);

        sqlSession.close();

        /**
         *
         *
         * blogMap.put("title","张麻子娶亲");
         * blogMap.put("author","张老头");
         * 查询条件两个：输出如下：
         *
         * [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 846947180.
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIFTwo]-==>  Preparing: select * from blog WHERE title = ? and author = ?
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIFTwo]-==> Parameters: 张麻子娶亲(String), 张老头(String)
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIFTwo]-<==      Total: 1
         * Blog(id=1, title=张麻子娶亲, author=张老头, createTime=2023-11-23 00:00:00, views=30)
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@327b636c]
         *
         *
         * blogMap.put("title","张麻子娶亲");
         * 查询条件一个输出如下
         *
         * [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 1172131546.
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIF]-==>  Preparing: select * from blog where 1=1 and title = ?
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIF]-==> Parameters: 张麻子娶亲(String)
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIF]-<==      Total: 1
         * Blog(id=1, title=张麻子娶亲, author=张老头, createTime=2023-11-23 00:00:00, views=30)
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@45dd4eda]
         *
         *
         *
         *
         **/
    }

    /**
     * @description: trim (where, set)的使用 修改
     * @author: zhengyuzhu
     * @date: 2023/11/23 13:36
     **/
    @Test
    public void testDemo4(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> blogMap = new HashMap<>();
        blogMap.put("title","张麻子娶亲");
        blogMap.put("author","张老头");

        Blog blog = blogMapper.queryBlogIFTwo(blogMap);//查询

        System.out.println("修改前的数据:" + blog);

        HashMap<String, Object> blogMapTwo = new HashMap<>();
        blogMapTwo.put("id",1);
        blogMapTwo.put("title","如何学号java ?");
        blogMapTwo.put("author","小明");
        Blog blog1 = new Blog();
        blog1.setAuthor("如何学号java ?");
        blog1.setAuthor("小明");
        blogMapper.updateBlog(blogMapTwo);//修改

        HashMap<String, Object> blogMap3 = new HashMap<>();
        blogMap3.put("title","如何学号java ?");

        Blog blog2 = blogMapper.queryBlogIFTwo(blogMap3);//查询
        System.out.println("修改后的数据:" + blog2);

        sqlSession.close();

        /**
         *
         *
         * blogMapTwo.put("id",1);
         * blogMapTwo.put("title","如何学号java ?");
         * blogMapTwo.put("author","小明");
         * 查询条件两个：输出如下：
         *
         * [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 846947180.
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIFTwo]-==>  Preparing: select * from blog WHERE title = ? and author = ?
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIFTwo]-==> Parameters: 张麻子娶亲(String), 张老头(String)
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIFTwo]-<==      Total: 1
         * 修改前的数据:Blog(id=1, title=张麻子娶亲, author=张老头, createTime=2023-11-23 00:00:00, views=30)
         * [com.zyz.mybatis.mapper.BlogMapper.updateBlog]-==>  Preparing: update blog SET title = ?, author = ? where id = ?
         * [com.zyz.mybatis.mapper.BlogMapper.updateBlog]-==> Parameters: 如何学号java ?(String), 小明(String), 1(Integer)
         * [com.zyz.mybatis.mapper.BlogMapper.updateBlog]-<==    Updates: 1
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIFTwo]-==>  Preparing: select * from blog WHERE title = ?
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIFTwo]-==> Parameters: 如何学号java ?(String)
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIFTwo]-<==      Total: 1
         * 修改后的数据:Blog(id=1, title=如何学号java ?, author=小明, createTime=2023-11-23 00:00:00, views=30)
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@327b636c]
         *
         *
         *
         **/
    }


    /**
     * @description:  Foreach 的使用
     * @author: zhengyuzhu
     * @date: 2023/11/23 14:03
     **/
    @Test
    public void testDemo5(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        ArrayList<Object> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);

        HashMap<String, Object> blogMap = new HashMap<>();
        blogMap.put("ids",idList);
        List<Blog> blogList = blogMapper.queryBlogForeach(blogMap);//查询

        for(Blog blog : blogList){
            System.out.println(blog);
        }

        sqlSession.close();

        /**
         *
         *
         * 查询条件两个：输出如下：
         *
         * [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 360062456.
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogForeach]-==>  Preparing: select * from blog WHERE ( id = ? or id = ? or id = ? )
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogForeach]-==> Parameters: 1(Integer), 2(Integer), 3(Integer)
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogForeach]-<==      Total: 3
         * Blog(id=1, title=如何学号java ?, author=小明, createTime=2023-11-23 00:00:00, views=30)
         * Blog(id=2, title=张麻子学java, author=李老头, createTime=2023-11-22 00:00:00, views=560)
         * Blog(id=3, title=张麻子学数据库, author=米老头, createTime=2023-11-22 00:00:00, views=760)
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@15761df8]
         *
         *
         *
         **/
    }


    /**
     * @description: IF 的使用 复用代码片段
     * @author: zhengyuzhu
     * @date: 2023/11/23 14:33
     **/
    @Test
    public void testDemo6(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> blogMap = new HashMap<>();
        blogMap.put("title","张麻子娶亲");
        blogMap.put("author","张老头");

        Blog blog = blogMapper.queryBlogIF(blogMap);//查询

        System.out.println(blog);

        sqlSession.close();

        /**
         *
         *
         * blogMap.put("title","张麻子娶亲");
         * blogMap.put("author","张老头");
         *
         * 查询条件两个：输出如下：
         *
         * [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 846947180.
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIF]-==>  Preparing: select * from blog where 1=1 and title = ? and author = ?
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIF]-==> Parameters: 张麻子娶亲(String), 张老头(String)
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIF]-<==      Total: 1
         * Blog(id=1, title=张麻子娶亲, author=张老头, createTime=2023-11-23 00:00:00, views=30)
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@327b636c]
         *
         *
         * blogMap.put("title","张麻子娶亲");
         * 查询条件一个输出如下
         *
         * [org.apache.ibatis.datasource.pooled.PooledDataSource]-Created connection 1172131546.
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIF]-==>  Preparing: select * from blog where 1=1 and title = ?
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIF]-==> Parameters: 张麻子娶亲(String)
         * [com.zyz.mybatis.mapper.BlogMapper.queryBlogIF]-<==      Total: 1
         * Blog(id=1, title=张麻子娶亲, author=张老头, createTime=2023-11-23 00:00:00, views=30)
         * [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@45dd4eda]
         *
         *
         *
         *
         **/
    }
}
