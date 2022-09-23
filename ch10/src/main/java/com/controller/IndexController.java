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
//    @RequestMapping(value = "/index/login")
    @RequestMapping(value = "/login")
    public String login(HttpSession session, HttpServletRequest request) {
        session.setAttribute("skey", "session范围的值");
        request.setAttribute("rkey", "request范围的值");
        return "login";
    }


//    @RequestMapping(value = "/index/register")
    @RequestMapping(value = "/register")
    public String register(Model model) {
        model.addAttribute("success", "注册成功");
        return "register";
    }

    //重定向
    /*@RequestMapping("/login")
    public String login() {
        return "forward:/index/idLogin";
    }

    @RequestMapping("/isLogin")
    public String isLogin() {
        //重定向到一个请求方法
        return "redirect:/index/isRegister";
    }

    @RequestMapping("/isRegister")
    public String isRegister() {
        //转发到一个视图
        return "register";
    }*/
}
