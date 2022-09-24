package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    PageInfo <Employee> getAllEmployeePage(Integer pageNum);
}
