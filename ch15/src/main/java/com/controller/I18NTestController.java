package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class I18NTestController {
    @RequestMapping("/i18NTest")
    //locale接收请求参数locale值, 并存储到session中
    public String first(Locale locale) {
        return "first";
    }
}
