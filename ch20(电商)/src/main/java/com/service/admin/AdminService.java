package com.service.admin;

import com.pojo.Auser;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface AdminService {
	public String login(Auser auser, Model model, HttpSession session);
}
