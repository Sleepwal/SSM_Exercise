package com.service;

import com.pojo.UserForm;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(UserForm user) {
        return "SleepWalker".equals(user.getUname()) && "123".equals(user.getUpass());
    }

    @Override
    public boolean register(UserForm user) {
        return "SleepWalker".equals(user.getUname()) && "123".equals(user.getUpass());
    }
}
