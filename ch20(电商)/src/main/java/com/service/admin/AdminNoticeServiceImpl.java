package com.service.admin;

import com.mapper.AdminNoticeMapper;
import com.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

@Service
@Transactional
public class AdminNoticeServiceImpl implements AdminNoticeService{
	@Autowired
	private AdminNoticeMapper adminNoticeMapper;

	/**
	 * @param notice:
	 * @return String
	 * @author SleepWalker
	 * @description 添加公告,到删除公告页面
	 * @date  18:18
	 */
	@Override
	public String addNotice(Notice notice) {
		adminNoticeMapper.addNotice(notice);
		return "forward:/adminNotice/deleteNoticeSelect";
	}

	/**
	 * @param model:
	 * @return String
	 * @author SleepWalker
	 * @description 删除公告
	 * @date  18:18
	 */
	@Override
	public String deleteNoticeSelect(Model model) {
		model.addAttribute("allNotices", adminNoticeMapper.deleteNoticeSelect());
		return "admin/deleteNoticeSelect";
	}

	/**
	 * @param model:
	 * @param id:
	 * @return String
	 * @author SleepWalker
	 * @description 公告详情
	 * @date  18:18
	 */
	@Override
	public String selectANotice(Model model, Integer id) {
		model.addAttribute("notice", adminNoticeMapper.selectANotice(id));
		return "admin/noticeDetail";
	}

	/**
	 * @param id:
	 * @return String
	 * @author SleepWalker
	 * @description 删除公告
	 * @date  18:19
	 */
	@Override
	public String deleteNotice(Integer id) {
		adminNoticeMapper.deleteNotice(id);
		return "forward:/adminNotice/deleteNoticeSelect";
	}

}
