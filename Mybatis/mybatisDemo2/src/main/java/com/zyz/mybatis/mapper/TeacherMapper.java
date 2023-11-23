package com.zyz.mybatis.mapper;

import com.zyz.mybatis.vo.TeacherT;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/22 22:24
 * @Description:
 */
public interface TeacherMapper {
    
    /**
     * @description: 1、按照结果嵌套处理  多对一
     * @author: zhengyuzhu
     * @date: 2023/11/22 23:50  
     * @return: com.zyz.mybatis.vo.Teacher
     **/
    TeacherT getTeacherById(Integer id);

    /**
     * @description:  2、按照查询嵌套处理   一对多
     * @author: zhengyuzhu
     * @date: 2023/11/23 0:12
     * @param: id
     * @return: com.zyz.mybatis.vo.TeacherT
     **/
    TeacherT getTeacher2(Integer id);

}
