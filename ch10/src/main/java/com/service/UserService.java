package com.service;

import com.pojo.UserForm;

public interface UserService {
    boolean login(UserForm user);
    boolean register(UserForm user);
}
