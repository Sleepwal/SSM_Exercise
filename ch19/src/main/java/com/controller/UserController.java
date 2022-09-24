package com.controller;


import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
     @Autowired
    private UserService userService;

     @RequestMapping("input")
     public String input() {
         return "input";
     }

     @RequestMapping("/select")
    public String select(String username, Model model) {
         List<User> list = userService.selectUserByName(username);
         model.addAttribute("list", list);

         return "userList";
     }
}
