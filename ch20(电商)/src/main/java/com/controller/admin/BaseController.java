package com.controller.admin;

import com.exception.AdminLoginNoException;
import com.exception.MyExceptionHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class BaseController extends MyExceptionHandler {
  /**
   * @param session: 
   * @param request: 
   * @return void
   * @author manson
   * @description 登录权限控制, 在处理方法前执行该方法
   * @date  16:54
   */
    @ModelAttribute
    public void isLogin(HttpSession session, HttpServletRequest request) throws AdminLoginNoException {
        if(session.getAttribute("auser") == null) {
            throw new AdminLoginNoException("您还未登录!");
        }
    }
}
