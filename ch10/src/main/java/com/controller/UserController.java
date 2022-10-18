package com.controller;

import com.pojo.UserForm;
import com.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    //记录日志的对象
    private static final Log logger = LogFactory.getLog(UserController.class);
    @Autowired
    public UserService userService;

    @RequestMapping("/login")
    public String login(UserForm user, HttpSession session, Model model) {
        if (userService.login(user)) {
            session.setAttribute("u", user);
            logger.info("成功");
            //登录成功,跳转到main.jsp
            return "main";
        } else {
            logger.info("失败");
            model.addAttribute("messageError", "用户名或密码错误");
            return "login";
        }
    }

    @RequestMapping("/register")
    public String register(@ModelAttribute("user") UserForm user) {
        if(userService.register(user)) {
            logger.info("成功");
            //登录成功,跳转到login.jsp
            return "login";
        }
        else {
            logger.info("失败");
            //使用@ModelAttribute("user") 等价于 model.addAttribute("uname", user.getUname());
            //返回register.jsp
            return "register";
        }
    }

    /*@RequestMapping("/login")
    public String login(UserForm user, HttpSession session, Model model) {
        if ("SleepWalker".equals(user.getUname()) && "123".equals(user.getUpass())) {
            session.setAttribute("u", user);
            logger.info("成功");
            //登录成功,跳转到main.jsp
            return "main";
        } else {
            logger.info("失败");
            model.addAttribute("messageError", "用户名或密码错误");
            return "login";
        }
    }*/

    //1.通过Bean接收参数
    @RequestMapping("/register1")
    public String register1(UserForm user, Model model) {
        if("SleepWalker".equals(user.getUname()) && "123".equals(user.getUpass())) {
            logger.info("成功");
            //登录成功,跳转到login.jsp
            return "login";
        }
        else {
            logger.info("失败");
            model.addAttribute("uname", user.getUname());
            //返回register.jsp
            return "register";
        }
    }

    //2.通过形参接收参数
    @RequestMapping("/register2")
    public String register2(String uname, String upass, Model model) {
        if("SleepWalker".equals(uname) && "123".equals(upass)) {
            logger.info("成功");
            //登录成功,跳转到login.jsp
            return "login";
        }
        else {
            logger.info("失败");
            model.addAttribute("uname", uname);
            //返回register.jsp
            return "register";
        }
    }

    //3.通过HttpServletRequest接收参数
    @RequestMapping("/register3")
    public String register3(HttpServletRequest request, Model model) {
        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");

        if("SleepWalker".equals(uname) && "123".equals(upass)) {
            logger.info("成功");
            //登录成功,跳转到login.jsp
            return "login";
        }
        else {
            logger.info("失败");
            model.addAttribute("uname", uname);
            //返回register.jsp
            return "register";
        }
    }

    //4.通过@PathVariable接收URL中的请求参数
    //必须加method属性
   @RequestMapping(value = "/register4/{uname}/{upass}", method = RequestMethod.GET)
    public String register4(@PathVariable String uname, @PathVariable String upass, Model model) {
        if("SleepWalker".equals(uname) && "123".equals(upass)) {
            logger.info("成功");
            //登录成功,跳转到login.jsp
            return "login";
        }
        else {
            logger.info("失败");
            model.addAttribute("uname", uname);
            //返回register.jsp
            return "register";
        }
    }

    //5.通过@RequestParam接收请求参数
    @RequestMapping("/register5")
    public String register5(@RequestParam String uname, @RequestParam String upass, Model model) {
        if ("SleepWalker".equals(uname) && "123".equals(upass)) {
            logger.info("成功");
            //登录成功,跳转到login.jsp
            return "login";
        } else {
            logger.info("失败");
            model.addAttribute("uname", uname);
            //返回register.jsp
            return "register";
        }
    }

    //6.通过@ModelAttribute接收请求参数
    @RequestMapping("/register6")
    public String register6(@ModelAttribute("user") UserForm user) {
        if("SleepWalker".equals(user.getUname()) && "123".equals(user.getUpass())) {
            logger.info("成功");
            //登录成功,跳转到login.jsp
            return "login";
        }
        else {
            logger.info("失败");
            //使用@ModelAttribute("user") 等价于 model.addAttribute("uname", user.getUname());
            //返回register.jsp
            return "register";
        }
    }

}
