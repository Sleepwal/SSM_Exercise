package com.service;

import com.pojo.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    //使用静态集合变量users模拟数据库
    private static ArrayList<User> users = new ArrayList<>();

    @Override
    public boolean addUser(User u) {
        if(!"打螺丝".equals(u.getCarrer())){
            users.add(u);
            return true;
        }

        return false;
    }

    @Override
    public ArrayList<User> getUsers() {
        return users;
    }
}
