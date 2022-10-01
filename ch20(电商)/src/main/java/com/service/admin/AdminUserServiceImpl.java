package com.service.admin;

import com.mapper.AdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

/**
 * @package: com.service.admin
 * @className: AdminUserServiceImpl
 * @author: SleepWalker
 * @description: UserService
 * @date: 16:16
 * @version: 1.0
 */
@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;

    /**
     * @param model:
     * @return String
     * @author SleepWalker
     * @description 查询所有用户,到用户管理
     * @date  16:22
     */
    @Override
    public String userInfo(Model model) {
        List<Map<String, Object>> list = adminUserMapper.userInfo();
        model.addAttribute("userList", list);
        return "admin/userManager";
    }

    /**
     * @param id:
     * @param model:
     * @return String
     * @author SleepWalker
     * @description 删除用户,到用户管理
     * @date  16:22
     */
    @Override
    public String deleteUserManager(Long id, Model model) {
        if(adminUserMapper.deleteUser(id) > 0)
            model.addAttribute("msg", "用户删除成功!");
        else
            model.addAttribute("msg", "用户删除失败!");

        return "forward:/adminUser/userInfo";
    }
}
