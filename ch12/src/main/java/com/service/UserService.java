package com.service;

import com.pojo.User;

import java.util.ArrayList;

public interface UserService {
    boolean addUser(User u);
    ArrayList<User> getUsers();
}
