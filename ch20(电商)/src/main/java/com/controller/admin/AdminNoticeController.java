package com.controller.admin;
import com.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.service.admin.AdminNoticeService;

@Controller
@RequestMapping("/adminNotice")
public class AdminNoticeController extends BaseController{
	@Autowired
	private AdminNoticeService adminNoticeService;
	
	/**
	 * @param model: 
	 * @return String
	 * @author SleepWalker
	 * @description 到添加公告页面
	 * @date  18:20
	 */
	@RequestMapping("/toAddNotice")
	public String toAddNotice(Model model) {
		model.addAttribute("notice", new Notice());
		return "admin/addNotice";
	}
	
	/**
	 * @param notice: 
	 * @return String
	 * @author SleepWalker
	 * @description 添加公告
	 * @date  18:20
	 */
	@RequestMapping("/addNotice")
	public String addNotice(@ModelAttribute Notice notice) {
		return adminNoticeService.addNotice(notice);
	}
	
	/**
	 * @param model: 
	 * @return String
	 * @author SleepWalker
	 * @description 删除公告
	 * @date  18:21
	 */
	@RequestMapping("/deleteNoticeSelect")
	public String deleteNoticeSelect(Model model) {
		return adminNoticeService.deleteNoticeSelect(model);
	}
	
	/**
	 * @param model: 
	 * @param id: 
	 * @return String
	 * @author SleepWalker
	 * @description  一个公告
	 * @date  18:21
	 */
	@RequestMapping("/selectANotice")
	public String selectANotice(Model model, Integer id) {
		return adminNoticeService.selectANotice(model, id);
	}

	/**
	 * @param id:
	 * @return String
	 * @author SleepWalker
	 * @description 删除公告
	 * @date  18:21
	 */
	@RequestMapping("/deleteNotice")
	public String deleteNotice(Integer id) {
		return adminNoticeService.deleteNotice(id);
	}
}
