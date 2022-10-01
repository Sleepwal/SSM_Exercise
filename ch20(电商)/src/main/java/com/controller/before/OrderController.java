package com.controller.before;

import com.service.before.CartService;
import com.service.before.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @package: com.controller.before
 * @className: OrderController
 * @author: SleepWalker
 * @description: 订单控制器
 * @date: 20:41
 * @version: 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseBeforeController  {
    @Autowired
    private OrderService orderService;

    /**
     * @param model:
     * @param session:
     * @param amount:
     * @return String
     * @author SleepWalker
     * @description 提交订单
     * @date  20:51
     */
    @RequestMapping("/orderSubmit")
    public String orderSubmit(Model model, HttpSession session, Double amount) {
        return orderService.orderSubmit(model, session, amount);
    }

    /**
     * @param ordersn:
     * @return String
     * @author SleepWalker
     * @description 支付订单
     * @date  20:51
     */
    @RequestMapping("/pay")
    public String pay(Integer ordersn) {
        return orderService.pay(ordersn);
    }
}
