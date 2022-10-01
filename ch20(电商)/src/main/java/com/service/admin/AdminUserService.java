package com.service.admin;

import org.springframework.ui.Model;

public interface AdminUserService {
    String userInfo(Model model);
    String deleteUserManager(Long id, Model model);
}
