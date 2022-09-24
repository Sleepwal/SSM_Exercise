package com.controller;

import com.github.pagehelper.PageInfo;
import com.pojo.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee/page/{pageNum}", method = RequestMethod.GET)
    public String employeePage(@PathVariable Integer pageNum, Model model) {
        //获取员工的分页信息
        PageInfo<Employee> page = employeeService.getAllEmployeePage(pageNum);
        //将员工分页信息添加到请求域中
        model.addAttribute("page", page);

        return "employee_list";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String employee(Model model) {
        List<Employee> list = employeeService.getAllEmployee();
        model.addAttribute("list", list);

        return "employee_list";
    }
}
