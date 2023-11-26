package com.zyz.mvc.controller;

import com.zyz.mvc.dao.EmployeeDao;
import com.zyz.mvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author zyz
 * @version 1.0
 * @data 2022/11/28 22:00
 * @Description:
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;


    /**
     * 查询所有员工信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        Collection<Employee> employeeList = employeeDao.getAll();
        model.addAttribute("employeeList",employeeList);
        return "employee_list";
    }

    /**
     * 删除员工信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id ){
        employeeDao.delete(id);
        return "redirect:/employee";
    }

    /**
     * 添加用户信息
     * @param employee
     * @return
     */
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    /**
     * 跳转修改员工信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String toUpdateEmployee(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "employee_update";
    }


    /**
     * 修改用户信息
     * @param employee
     * @return
     */
    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String upDateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }


}
