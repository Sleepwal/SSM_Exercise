package com.controller.admin;

import com.mapper.AdminTypeMapper;
import com.pojo.Goods;
import com.service.admin.AdminGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @package: com.controller.admin
 * @className: AdminGoodsController
 * @author: SleepWalker
 * @description: 商品控制器
 * @date: 17:43
 * @version: 1.0
 */
@Controller
@RequestMapping("/adminGoods")
public class AdminGoodsController {
    @Autowired
    AdminGoodsService adminGoodsService;
    @Autowired
    AdminTypeMapper adminTypeMapper;

    /**
     * @param model:
     * @return String
     * @author SleepWalker
     * @description add页面初始化
     * @date  18:36
     */
    @RequestMapping("/toAddGoods")
    public String toAddGoods(Model model) {
        model.addAttribute("goods", new Goods());
        model.addAttribute("goodsType", adminTypeMapper.selectGoodsType());
        return "admin/addGoods";
    }

    /**
     * @param goods:
     * @param request:
     * @param updateAct:
     * @return String
     * @author SleepWalker
     * @description 添加与修改
     * @date  18:38
     */
    @RequestMapping("/addGoods")
    public String addGoods(@ModelAttribute Goods goods, HttpServletRequest request, String updateAct) {
        return adminGoodsService.addOrUpdateGoods(goods, request, updateAct);
    }

    /**
     * @param model:
     * @param pageCur:
     * @param act:
     * @return String
     * @author SleepWalker
     * @description 所有商品
     * @date  23:01
     */
    @RequestMapping("/selectGoods")
    public String selectGoods(Model model, Long pageCur, String act) {
        return adminGoodsService.selectGoods(model, pageCur, act);
    }

    /**
     * @param model:
     * @param id:
     * @param act:
     * @return String
     * @author SleepWalker
     * @description 查询一个商品
     * @date  23:03
     */
    @RequestMapping("/selectAGoods")
    public String selectAGoods(Model model, Long id, String act) {
        return adminGoodsService.selectAGoods(model, id, act);
    }
}
