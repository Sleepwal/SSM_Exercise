package com.controller.before;

import com.pojo.Buser;
import com.pojo.Goods;
import com.service.before.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @package: com.controller.before
 * @className: IndexController
 * @author: SleepWalker
 * @description: 首页控制器
 * @date: 22:28
 * @version: 1.0
 */
@Controller
public class IndexController {
 @Autowired
    private IndexService indexService;

    /**
     * @param model:
     * @param session:
     * @param goods:
     * @return String
     * @author SleepWalker
     * @description 首页
     * @date  23:18
     */
    @RequestMapping("/before")
    public String before(Model model, HttpSession session, Goods goods){
        return indexService.before(model, session, goods);
    }

    /**
     * @param model:
     * @param mykey:
     * @return String
     * @author SleepWalker
     * @description 搜索
     * @date  23:18
     */
    @RequestMapping("/search")
    public String search(Model model, String mykey) {
        return indexService.search(model, mykey);
    }

    @RequestMapping("/toRegister")
    public String toRegister(Model model) {
        return indexService.toRegister(model);
    }

    /**
     * @param model:
     * @return String
     * @author SleepWalker
     * @description 到登录页
     * @date  15:48
     */
    @RequestMapping("/toLogin")
    public String toLogin(Model model) {
        return indexService.toLogin(model);
    }

    /**
     * @param model:
     * @param id:
     * @return String
     * @author SleepWalker
     * @description 到商品详情页
     * @date  15:48
     */
    @RequestMapping("/goodsDetail")
    public String goodsDetail(Model model, Integer id) {
        return indexService.goodsDetail(model, id);
    }
}
