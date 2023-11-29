package com.zheng.service;

import com.zheng.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    /**
     * 增加一本书
     */
    int addBook(Books books);


    /**
     * 删除一本书
     */

    int deleteBookById(int id);

    /**
     * 更新一本书
     */

    int updateBook(Books books);


    /**
     * 查询所有的书籍
     */

    List<Books> queryAllBook();


    /**
     * 查询一本书籍通过id
     */

    Books queryBookById(int id);

    /**
     * 通过书名查询书籍
     */

    public Books queryBookByName(@Param("bookName") String bookName);
}
