package com.controller.before;

import com.service.before.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @package: com.controller.before
 * @className: CartController
 * @author: SleepWalker
 * @description: TODO
 * @date: 16:47
 * @version: 1.0
 */
@RequestMapping("/cart")
@Controller
public class CartController extends BaseBeforeController  {
    @Autowired
    private CartService cartService;

    /**
     * @param model:
     * @param id:
     * @param session:
     * @return String
     * @author SleepWalker
     * @description 关注商品
     * @date  16:48
     */
    @RequestMapping("/focus")
    public String focus(Model model, Integer id, HttpSession session) {
        return cartService.focus(model, id, session);
    }

    /**
     * @param model:
     * @param shoppingnum:
     * @param id:
     * @param session:
     * @return String
     * @author SleepWalker
     * @description 添加购物车
     * @date  19:18
     */
    @RequestMapping("/putCart")
    public String putCart(Model model, Integer shoppingnum, Integer id, HttpSession session) {
        return cartService.putCart(model, shoppingnum, id, session);
    }

    /**
     * @param model:
     * @param session:
     * @return String
     * @author SleepWalker
     * @description 查询购物车
     * @date  19:19
     */
    @RequestMapping("/selectCart")
    public String selectCart(Model model, HttpSession session) {
        return cartService.selectCart(model, session);
    }

    /**
     * @param id:
     * @param session:
     * @return String
     * @author SleepWalker
     * @description 删除购物车
     * @date  19:20
     */
    @RequestMapping("/deleteAgoods")
    public String deleteAgoods(Integer id, HttpSession session) {
        return cartService.deleteAGoods(id, session);
    }

    /**
     * @param session:
     * @return String
     * @author SleepWalker
     * @description 清空购物车
     * @date  19:21
     */
    @RequestMapping("/clear")
    public String clear(HttpSession session) {
        return cartService.clear(session);
    }

    /**
     * @param model:
     * @param session:
     * @return String
     * @author SleepWalker
     * @description 去结算
     * @date  20:44
     */
    @RequestMapping("/orderConfirm")
    public String orderConfirm(Model model, HttpSession session) {
        return cartService.orderConfirm(model, session);
    }
}
