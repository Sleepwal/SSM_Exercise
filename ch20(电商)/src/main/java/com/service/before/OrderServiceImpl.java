package com.service.before;

import com.mapper.CartMapper;
import com.mapper.OrderMapper;
import com.pojo.Order;
import com.util.MyUtil;
import javafx.beans.binding.ObjectBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @package: com.service.before
 * @className: OrderServiceImpl
 * @author: SleepWalker
 * @description: TODO
 * @date: 20:15
 * @version: 1.0
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * @param model:
     * @param session:
     * @param amount:
     * @return String
     * @author SleepWalker
     * @description 订单提交, 连续的事务处理
     * @date  20:25
     */
    @Override
    public String orderSubmit(Model model, HttpSession session, Double amount) {
        Order order = new Order();
        order.setAmount(amount);
        order.setBusertable_id((int) MyUtil.getUserId(session));

        //生成订单, 并将主键返回order
        orderMapper.addOrder(order);

        //生成订单详情
        Map<String, Object> map = new HashMap<>();
        map.put("ordersn", order.getId());
        map.put("uid", MyUtil.getUserId(session));
        orderMapper.addOrderDetail(map);

        //更新商品库存
        //更新商品库存1, 查询商品购买量, 以便更新库存使用
        List<Map<String, Object>> list = orderMapper.selectGoodsShop((int) MyUtil.getUserId(session));
        //更新商品库存2, 根据商品购买量更新库存
        for(Map<String, Object>map2 : list) {
            orderMapper.updateStore(map2);
        }

        //清空购物车
        orderMapper.clear((int) MyUtil.getUserId(session));
        model.addAttribute("ordersn", order.getId());

        return "before/orderdone";
    }

    @Override
    public String pay(Integer ordersn) {
        orderMapper.pay(ordersn);
        return "before/paydone";
    }
}
