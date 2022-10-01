package com.controller.before;

import com.service.before.UserCenterService;
import com.service.before.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @package: com.controller.before
 * @className: UserCenterController
 * @author: SleepWalker
 * @description: 用户中心控制器
 * @date: 23:33
 * @version: 1.0
 */
@Controller
public class UserCenterController extends BaseBeforeController  {
    @Autowired
    private UserCenterService userCenterService;

    @RequestMapping("/userCenter")
    public String userCenter(HttpSession session, Model model) {
        return userCenterService.userCenter(session, model);
    }

    @RequestMapping("/orderDetail")
    public String orderDetail(Model model, Long ordersn) {
        return userCenterService.orderDetail(model, ordersn);
    }
}
