package com.controller;

import com.exception.MyException;
import com.service.TestExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
public class TestExceptionController extends BaseController {
    @Autowired
    private TestExceptionService testExceptionService;

    @RequestMapping("/db")
    public void db() throws Exception {
        throw new SQLException("控制器中数据库异常");
    }

    @RequestMapping("/my")
    public void my() throws Exception {
        throw new MyException("控制器中自定义异常");
    }

    @RequestMapping("/no")
    public void no() throws Exception {
        throw new Exception("控制器中未知异常");
    }

    @RequestMapping("/servicedb")
    public void servicedb() throws Exception {
        testExceptionService.serviceSQL();
    }

    @RequestMapping("/servicemy")
    public void servicemy() throws Exception {
        testExceptionService.serviceMy();
    }

    @RequestMapping("/serviceno")
    public void serviceno() throws Exception {
        testExceptionService.serviceNo();
    }

    @RequestMapping("/daodb")
    public void daodb() throws Exception {
        testExceptionService.daoSQL();
    }

    @RequestMapping("/daomy")
    public void daomy() throws Exception {
        testExceptionService.daoMy();
    }

    @RequestMapping("/daono")
    public void daono() throws Exception {
        testExceptionService.daoNo();
    }


}
