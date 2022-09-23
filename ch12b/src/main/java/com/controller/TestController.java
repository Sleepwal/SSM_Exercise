package com.controller;

import com.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    //接收页面请求的JSON数据, 并返回JSON格式的结果
    @RequestMapping("/testJson")
    @ResponseBody
    public Person testJson(@RequestBody Person person) {
        System.out.println(person);

        return person;
    }
}
