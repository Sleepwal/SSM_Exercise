package com.controller;

import com.exception.MyException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public abstract class BaseController {
    @ExceptionHandler
    public String exception(HttpServletRequest request, Exception ex) {
        request.setAttribute("ex", ex);

        //根据不同错误转向不同页面(统一处理), 即异常与View的对应关系
        if(ex instanceof SQLException) {
            return "sql-error";
        } else if(ex instanceof MyException) {
            return "my-error";
        } else  {
            return "error";
        }
    }
}
