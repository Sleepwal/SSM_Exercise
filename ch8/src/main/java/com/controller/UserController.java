package com.controller;

import com.mybatis.UserMapper;
import com.pojo.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserMapper userDao;

    public void test() {
        TUser user = new TUser();
//        user.setUsername("张");
        user.setUsername("S");
        user.setGender("男");

        List<TUser> list = userDao.selectUserByIf(user);
        list.forEach(System.out::println);
    }

    public void testChoose() {
        TUser user = new TUser();
        user.setUsername("");
        user.setGender("");

        List<TUser> list = userDao.selectUserByChoose(user);
        list.forEach(System.out::println);
    }

    public void testWhere() {
        TUser user = new TUser();
        user.setUsername("");
        user.setGender("");

        List<TUser> list = userDao.selectUserByWhere(user);
        list.forEach(System.out::println);
    }

    public int testSet() {
        TUser user = new TUser();
        user.setUid(1);
        user.setUsername("SleepWalker1111");

        return userDao.updateUserBySet(user);
    }

    public void testForeach() {
        List<Integer> listId = new ArrayList<>();
        listId.add(3);
        listId.add(17);
        List<TUser> list = userDao.selectUserByForeach(listId);
        list.forEach(System.out::println);
    }

    public void testBind() {
        TUser user = new TUser();
        user.setUsername("ad");

        List<TUser> list = userDao.selectUserByBind(user);
        list.forEach(System.out::println);
    }
}
