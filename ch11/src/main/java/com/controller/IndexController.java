package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
//类级别注解
@RequestMapping("/index")
public class IndexController {
    //方法级别注解
//    @RequestMapping(value = "/index/addGoods")
    @RequestMapping(value = "/addGoods")
    public String login() {
        return "addGoods";
    }

}
