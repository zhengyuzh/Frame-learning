package com.zyz.mybatis.mapper;

import com.zyz.mybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/22 14:37
 * @Description: User 实体类
 */
public interface UserMapper {

    /**
     *
     * 关于@Param()注解
     *
     * 基本类型的参数或者String类型，需要加上
     * 引用类型不需要加
     * 如果只有一个基本类型的话，可以忽略，但是建议都加上！
     * 我们在SQL中引用的就是我们这里的@Param("")中设定的属性名！
     *
     **/

    /**
     * @description: 查询用户
     * @author: zhengyuzhu
     * @date: 2023/11/22 14:40
     * @return: java.util.List<com.zyz.mybatis.entity.User>
     **/
    @Select("select * from user")
    @Results(id = "UserMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "pwd",property = "password")
    })
    List<User> getUsers();

    /**
     * @description: 查询用户 通过 用户ID 方法存在多个参数，所有参数前面必须加上@Param("id")注解
     * @author: zhengyuzhu
     * @date: 2023/11/22 15:12
     * @param: id
     * @return: com.zyz.mybatis.entity.User
     **/
    @Select("select * from user where id=#{id}")
    @ResultMap(value = ("UserMap"))
    User getUserById(@Param("id") int id);


    /**
     * @description: 添加用户
     * @author: zhengyuzhu
     * @date: 2023/11/22 15:11
     * @param: user
     * @return: int
     **/
    @Insert("insert into user (id,name,pwd) values(#{id},#{name},#{password})")
    int addUser(User user);

    /**
     * @description: 修改用户
     * @author: zhengyuzhu
     * @date: 2023/11/22 15:11
     * @param: user
     * @return: int
     **/
    @Update("update user set name=#{name},pwd=#{password} where id=#{id}")
    int updateUser(User user);


    /**
     * @description:删除用户  可以通过@Param("") 给传递的参数 修改别名
     * @author: zhengyuzhu
     * @date: 2023/11/22 15:11
     * @param: id
     * @return: int
     **/
    @Delete("delete from user where id = #{uid}")
    int deleteUser(@Param("uid") int id);



}
