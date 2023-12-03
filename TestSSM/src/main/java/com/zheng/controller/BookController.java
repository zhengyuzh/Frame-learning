package com.zheng.controller;

import com.zheng.pojo.Books;
import com.zheng.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 查询所有的书籍，并且返回一个书籍展示页面
     * @param model
     * @return
     */
    @RequestMapping("/queryAll")
    public String list(Model model){
        List<Books> lists = bookService.queryAllBook();
        model.addAttribute("list",lists);
        return "allBook";
    }


    /**
     * 跳转到添加书籍界面
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAddBook(){
        return "addBook";
    }

    /**
     * 添加书籍
     * @param books
     * @return
     */
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("查看数据："+books);
        String name = "lisi";
        System.out.println("=============="+name);
        boolean flag = true;
        if(flag){
            try {
                Thread.sleep(1000);

            }catch (Exception e){

            }
        }

        bookService.addBook(books);
        return "redirect:/book/queryAll";
    }

    /**
     * 首先跳转到修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toUpdate")
    public String toUpdateBook(int id,Model model){
     Books books=   bookService.queryBookById(id);
        model.addAttribute("QBook",books);
        return "updateBook";
    }

    /**
     * 修改图书信息
     * @param books
     * @return
     */
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);
        return "redirect:/book/queryAll";
    }

    /**
     * 删除书籍
     * @param id
     * @return
     */
    @RequestMapping("/todelete")
    public String toDelete(int id){
        bookService.deleteBookById(id);
        return "redirect:/book/queryAll";

    }

    /**
     * 查询书籍
     * @param queryBookName
     * @param model
     * @return
     */
    @RequestMapping("/queryBookName")
    public String queryBookName(String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        List<Books> list = new ArrayList<Books>();
        list.add(books);

        if(books==null){
            list=bookService.queryAllBook();
            model.addAttribute("error","未查到相关书籍");
        }
        model.addAttribute("list",list);

        return "allBook";
    }





}

