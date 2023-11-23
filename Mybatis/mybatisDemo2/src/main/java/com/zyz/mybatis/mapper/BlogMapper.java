package com.zyz.mybatis.mapper;

import com.zyz.mybatis.entity.Blog;

import java.util.HashMap;
import java.util.List;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/23 11:18
 * @Description:
 */
public interface BlogMapper {

    /**
     * @description: IF的使用 查询博客
     * @author: zhengyuzhu
     * @date: 2023/11/23 11:27
     * @param: map
     * @return: com.zyz.mybatis.entity.Blog
     **/
    Blog queryBlogIF(HashMap<String,Object> map);
    
    /**
     * @description: choose (when, otherwise)的使用 查询博客
     * @author: zhengyuzhu
     * @date: 2023/11/23 11:30
     * @param: map 
     * @return: com.zyz.mybatis.entity.Blog
     **/
    Blog queryBlogChoose(HashMap<String,Object> map);

    /**
     * @description: trim (where, set)的使用 查询
     * @author: zhengyuzhu
     * @date: 2023/11/23 11:34
     * @param: map 
     * @return: com.zyz.mybatis.entity.Blog
     **/
    Blog queryBlogIFTwo(HashMap<String,Object> map);

    /**
     * @description: trim (where, set)的使用 修改
     * @author: zhengyuzhu
     * @date: 2023/11/23 11:35
     * @param: map 
     **/
    void updateBlog(HashMap<String,Object> map);
    
    
    /**
     * @description: Foreach 的使用
     * @author: zhengyuzhu
     * @date: 2023/11/23 14:02
     * @param: map 
     * @return: java.util.List<com.zyz.mybatis.entity.Blog>
     **/
    List<Blog> queryBlogForeach(HashMap<String,Object> map);


    /**
     * @description: IF的使用 使用代码片段
     * @author: zhengyuzhu
     * @date: 2023/11/23 11:27
     * @param: map
     * @return: com.zyz.mybatis.entity.Blog
     **/
    Blog queryBlogIFThree(HashMap<String,Object> map);


}
