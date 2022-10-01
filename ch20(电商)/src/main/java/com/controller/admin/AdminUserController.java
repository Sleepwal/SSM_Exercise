package com.controller.admin;

import com.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @package: com.controller.admin
 * @className: AdminUserController
 * @author: SleepWalker
 * @description: 用户管理控制器
 * @date: 16:23
 * @version: 1.0
 */
@Controller
@RequestMapping("/adminUser")
public class AdminUserController extends BaseController {
    @Autowired
    AdminUserService adminUserService;

    /**
     * @param model:
     * @return String
     * @author SleepWalker
     * @description 到用户管理
     * @date  16:25
     */
    @RequestMapping("/userInfo")
    public String userInfo(Model model) {
        return adminUserService.userInfo(model);
    }

    /**
     * @param id:
     * @param model:
     * @return String
     * @author SleepWalker
     * @description 删除用户
     * @date  16:25
     */
    @RequestMapping("/deleteuserManager")
    public String deleteuserManager(Long id, Model model){
        return adminUserService.deleteUserManager(id, model);
    }

}
