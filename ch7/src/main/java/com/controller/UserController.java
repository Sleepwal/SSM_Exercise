package com.controller;

import com.mybatis.UserMapper;
import com.pojo.SelectUserParam;
import com.pojo.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    public void test() {
        //查询姓张的男性
        /*Map<String, Object> map = new HashMap<>();
        map.put("username", "张");
        map.put("gender", "男");

        List<TUser> list = userMapper.selectUser(map);
        list.forEach(System.out::println);*/

        //查询姓张的男性
        SelectUserParam su = new SelectUserParam();
        su.setUsername("张");
        su.setGender("男");
        List<TUser> list1 = userMapper.selectUser(su);
        list1.forEach(System.out::println);

        //主键回填
        TUser tUser = new TUser();
        tUser.setUsername("SleepWalker");
        tUser.setGender("男");

        int add = userMapper.insertUser(tUser);
        System.out.println(add + "条记录");
        System.out.println("主键: " + tUser.getId());

        //Map存储所有用户
        /*System.out.println("\nMap存储所有用户");
        List<Map<String, Object>> userMap = userMapper.selectAllUserMap();*/

        //自定义结果集存储
        System.out.println("\n自定义结果集存储所有用户");
        List<TUser> userMap = userMapper.selectAllUserMap();
        userMap.forEach(System.out::println);
    }
}
