package com.controller;

import com.pojo.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/employee")
    public String employee(Model model) {
        List<Employee> list = employeeService.getAllEmployee();
        model.addAttribute("list", list);

        return "employee_list";
    }
}
