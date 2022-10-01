package com.controller.admin;

import com.service.admin.AdminOrderService;
import com.service.admin.AdminService;
import com.service.admin.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @package: com.controller.admin
 * @className: AdminOrderController
 * @author: SleepWalker
 * @description: 控制器
 * @date: 15:32
 * @version: 1.0
 */
@RequestMapping("/adminOrder")
@Controller
public class AdminOrderController extends BaseController {
    @Autowired
    AdminOrderService adminOrderService;

    /**
     * @param model:
     * @return String
     * @author SleepWalker
     * @description 到订单管理
     * @date  16:04
     */
    @RequestMapping("/orderInfo")
    public String orderInfo(Model model) {
        return adminOrderService.orderInfo(model);
    }

    /**
     * @param id:
     * @param model:
     * @return String
     * @author SleepWalker
     * @description 删除订单
     * @date  16:04
     */
    @RequestMapping("/deleteorderManager")
    public String deleteorderManager(Long id, Model model) {
        return adminOrderService.deleteOrderManager(id);
    }
}
