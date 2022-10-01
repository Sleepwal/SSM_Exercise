package com.controller.before;

import com.pojo.Buser;
import com.service.before.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @package: com.controller.before
 * @className: UserController
 * @author: SleepWalker
 * @description: 用户控制器
 * @date: 9:56
 * @version: 1.0
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * @param buser:
     * @param model:
     * @param session:
     * @param code:
     * @return String
     * @author SleepWalker
     * @description 注册
     * @date  10:11
     */
    @RequestMapping("/register")
    public String register(@ModelAttribute Buser buser, Model model, HttpSession session, String code) {
        return userService.register(buser, model, session, code);
    }

    /**
     * @param buser:
     * @param model:
     * @param session:
     * @param code:
     * @return String
     * @author SleepWalker
     * @description 登录
     * @date  10:43
     */
    @RequestMapping("/login")
    public String login(@ModelAttribute Buser buser, Model model, HttpSession session, String code) {
        return userService.login(buser, model, session, code);
    }

    @RequestMapping("/exit")
    public String exit(@ModelAttribute Buser buser, HttpSession session) {
        session.invalidate();
        return "before/login";
    }
}
