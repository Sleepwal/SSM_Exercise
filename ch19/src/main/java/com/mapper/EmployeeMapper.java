package com.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> getAllEmployee();
}
