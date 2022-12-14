package com.controller.admin;

import com.pojo.Auser;
import com.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	/**
	 * @param auser:
	 * @return String
	 * @author SleepWalker
	 * @description 跳转到登陆界面
	 * @date  22:15
	 */
	@RequestMapping("/admin")
	public String toLogin(@ModelAttribute Auser auser) {
		return "admin/login";
	}

	/**
	 * @param auser:
	 * @param model:
	 * @param session:
	 * @return String
	 * @author SleepWalker
	 * @description 处理登录
	 * @date  22:15
	 */
	@RequestMapping("/admin/login")
	public String login(@ModelAttribute Auser auser, Model model, HttpSession session) {
		return adminService.login(auser, model, session);
	}

	/**
	 * @param auser:
	 * @param session:
	 * @return String
	 * @author SleepWalker
	 * @description 退出登录
	 * @date  22:16
	 */
	@RequestMapping("/exit")
	public String exit(@ModelAttribute Auser auser,HttpSession session) {
		session.invalidate();
		return "admin/login";
	}
}
