package com.service.admin;

import com.mapper.AdminMapper;
import com.mapper.AdminTypeMapper;
import com.pojo.Auser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private AdminTypeMapper adminTypeMapper;

	/**
	 * @param auser:
	 * @param model:
	 * @param session:
	 * @return String
	 * @author SleepWalker
	 * @description 登录
	 * @date  22:13
	 */
	@Override
	public String login(Auser auser, Model model, HttpSession session) {
		if(adminMapper.login(auser) != null && adminMapper.login(auser).size() > 0) {
			session.setAttribute("auser", auser);
			//添加商品与修改商品页面使用
			session.setAttribute("goodsType", adminTypeMapper.selectGoodsType());
			return "admin/main";
		}
		model.addAttribute("msg", "用户名或密码错误！");
		return "admin/login";
	}

}
