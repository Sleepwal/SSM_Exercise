package com.controller.before;

import com.exception.UserLoginNoException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @package: com.controller.before
 * @className: BaseBeforeController
 * @author: SleepWalker
 * @description: TODO
 * @date: 16:58
 * @version: 1.0
 */
@Controller
public class BaseBeforeController {
    /**
     * @param session:
     * @param request:
     * @return void
     * @author SleepWalker
     * @description 前台用户登录全权限控制, 在处理方法前执行该方法
     * @date  17:01
     */

    @ModelAttribute
    public void IsLogin(HttpSession session, HttpServletRequest request) throws UserLoginNoException {
        if(session.getAttribute("buser") == null) {
            throw new UserLoginNoException("您还未登录!");
        }
    }
}
