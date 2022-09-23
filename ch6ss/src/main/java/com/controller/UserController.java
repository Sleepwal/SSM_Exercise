package com.controller;

import com.mybatis.UserMapper;
import com.pojo.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserMapper userDao;

    public void test() {
        //查询一个用户
        TUser tUser = userDao.selectUserById(1);
        System.out.println(tUser);
        System.out.println("----------");

        //添加一个用户
        TUser addUser = new TUser();
        addUser.setUsername("SleepWalker");
        addUser.setGender("男");
        int add = userDao.addUser(addUser);
        System.out.println("添加了" + add + "条记录");
        System.out.println("----------");

        //修改一个用户
        TUser updateUser = new TUser();
        updateUser.setUid(1);
        updateUser.setUsername("SleepWalker22222222");
        updateUser.setGender("男");
        int up = userDao.updateUser(updateUser);
        System.out.println("修改了" + up + "条记录");
        System.out.println("----------");

        //删除一个用户
        int dl = userDao.deleteUser(9);
        System.out.println("删除了" + dl + "条记录");
        System.out.println("----------");

        //查询所有用户
        List<TUser> list = userDao.selectAllUser();
        for(TUser user : list){
            System.out.println(user);
        }
    }
}
