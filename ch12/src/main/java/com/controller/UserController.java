package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //日志对象
    private static final Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/input")
    public String inputUser(Model model) {
        HashMap<String, String> hobbies = new HashMap<>();
        hobbies.put("篮球", "篮球");
        hobbies.put("唱", "唱");
        hobbies.put("跳", "跳");
        hobbies.put("rap", "rap");

        //如果model中没有user属性,userAdd.jsp会抛出异常
        //因为表单标签无法找到modelAttribute属性指定的form backing object
        model.addAttribute("user", new User());
        model.addAttribute("hobbies", hobbies);

        model.addAttribute("carrers", new String[] {"教师", "学生", "打螺丝", "cv工程师"});
        model.addAttribute("houseRegisters",
                new String[]{"北京", "上海", "广州", "深圳"});

        return "userAdd";
    }

    @RequestMapping("/save")
    public String addUser(@ModelAttribute User user, Model model) {
        if(userService.addUser(user)) {
            logger.info("成功");
            return "redirect:/user/list";
        }
        else {
            logger.info("失败");
            HashMap<String, String>hobbies = new HashMap<>();
            hobbies.put("篮球", "篮球");
            hobbies.put("唱", "唱");
            hobbies.put("跳", "跳");
            hobbies.put("rap", "rap");


            //不需要model.addAttribute("user", new User());
            //@ModelAttribute指定form backing object
            model.addAttribute("hobbies", hobbies);

            model.addAttribute("carrers", new String[] {"教师", "学生", "打螺丝", "cv工程师"});
            model.addAttribute("houseRegisters",
                    new String[]{"北京", "上海", "广州", "深圳"});

            return "userAdd";
        }
    }

    @RequestMapping("/list")
    public String listUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);

        return "userList";
    }

}
