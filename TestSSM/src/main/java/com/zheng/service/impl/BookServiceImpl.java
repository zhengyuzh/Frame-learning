package com.zheng.service.impl;

import com.zheng.dao.BookMapper;
import com.zheng.pojo.Books;
import com.zheng.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }
    /**
     * 通过书名查询书籍
     */

    @Override
    public Books queryBookByName(String bookName){
        return bookMapper.queryBookByName(bookName);
    };


}
