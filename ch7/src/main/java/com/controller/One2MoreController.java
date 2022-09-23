package com.controller;

import com.mybatis.UserMapper;
import com.pojo.MyUser;
import com.pojo.SelectUserOrdersById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class One2MoreController {
    @Autowired
    UserMapper userMapper;

    public void test() {
        MyUser myUser1 = userMapper.selectUserOrdersById1(1);
        System.out.println(myUser1);
        System.out.println("=====================");

        MyUser myUser2 = userMapper.selectUserOrdersById2(1);
        System.out.println(myUser2);
        System.out.println("=====================");

        List<SelectUserOrdersById> myUser3 = userMapper.selectUserOrdersById3(1);
        System.out.println(myUser3);
        System.out.println("=====================");

    }
}
