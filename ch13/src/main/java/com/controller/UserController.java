package com.controller;

import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    //登录初始化
    @RequestMapping("/toLogin")
    public String initLogin() {
        return "login";
    }

    //处理登录
    @RequestMapping("/login")
    public String login(User user, Model model, HttpSession session) {
        System.out.println(user.getUsername());
        if ("SleepWalker".equals(user.getUsername()) && "123".equals(user.getPassword())) {
            session.setAttribute("user", user);
            //重定向到主页面
            return "redirect:main";
        }

        model.addAttribute("msg", "用户名或密码错误");
        return "login";
    }

    //跳转到主页面
    @RequestMapping("/main")
    public String toMain() {
        return "main";
    }

    //退出登录
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //清除session
        session.invalidate();

        return "login";
    }
}
