package com.controller.admin;

import com.mapper.AdminTypeMapper;
import com.service.admin.AdminTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @package: com.controller
 * @className: AdminTypeController
 * @author: SleepWalker
 * @description: TODO
 * @date: 23:59
 * @version: 1.0
 */

@Controller
@RequestMapping("/adminType")
public class AdminTypeController extends BaseController {
    @Autowired
    AdminTypeService adminTypeService;

    /**
     * @param model:
     * @return String
     * @author SleepWalker
     * @description 到添加类型页面
     * @date  0:05
     */
    @RequestMapping("/toAddType")
    public String toAddType(Model model) {
        return adminTypeService.toAddType(model);
    }

    /**
     * @param typename:
     * @param model:
     * @param session:
     * @return String
     * @author SleepWalker
     * @description 添加类型
     * @date  0:05
     */
    @RequestMapping("/addType")
    public String addType(String typename, Model model, HttpSession session) {
        return adminTypeService.addType(typename, model, session);
    }

    /**
     * @param model: 
     * @return String
     * @author SleepWalker
     * @description 到删除页面
     * @date  12:28
     */
    @RequestMapping("/toDeleteType")
    public String toDeleteType(Model model) {
        return adminTypeService.toDeleteType(model);
    }

    /**
     * @param id:
     * @param model:
     * @return String
     * @author SleepWalker
     * @description 删除类型
     * @date  12:29
     */
    @RequestMapping("/deleteType")
    public String deleteType(long id, Model model) {
        return adminTypeService.deleteType(id, model);
    }
}
