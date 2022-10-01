package com.service.before;

import com.mapper.CartMapper;
import com.util.MyUtil;
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
 * @className: CartServiceImpl
 * @author: SleepWalker
 * @description: 购物车服务层
 * @date: 16:38
 * @version: 1.0
 */
@Service
@Transactional
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public String focus(Model model, Integer id, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", MyUtil.getUserId(session));
        map.put("gid", id);

        List<Map<String, Object>> list = cartMapper.isFocus(map);
        if(list.size() > 0) {
            model.addAttribute("msg", "已关注该商品!");
        } else {
            if(cartMapper.focus(map) > 0){
                model.addAttribute("msg", "成功关注该商品!");
            } else {
                model.addAttribute("msg", "关注失败!");
            }
        }

        return "forward:/goodsDetail?id=" + id;
    }


    @Override
    public String putCart(Model model, Integer shoppingnum, Integer id, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", MyUtil.getUserId(session));
        map.put("gid", id);
        map.put("shoppingnum", shoppingnum);

        //是否已添加购物车
        List<Map<String, Object>> list = cartMapper.isPutCart(map);
        if(list.size() > 0) {
            cartMapper.updateCart(map);
        } else {
            cartMapper.putCart(map);
        }

        return "forward:/cart/selectCart";
    }

    @Override
    public String selectCart(Model model, HttpSession session) {
        List<Map<String, Object>> list = cartMapper.selectCart((int) MyUtil.getUserId(session));
        double sum = 0;
        for(Map<String, Object> map : list) {
            sum += (Double)map.get("smallsum");
        }

        model.addAttribute("total", sum);
        model.addAttribute("cartlist", list);

        return "before/cart";
    }

    @Override
    public String deleteAGoods(Integer id, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", MyUtil.getUserId(session));
        map.put("gid", id);
        cartMapper.deleteAgoods(map);

        return "forward:/cart/selectCart";
    }

    @Override
    public String clear(HttpSession session) {
        cartMapper.clear((int) MyUtil.getUserId(session));
        return "forward:/cart/selectCart";
    }

    @Override
    public String orderConfirm(Model model, HttpSession session) {
        List<Map<String, Object>> list = cartMapper.selectCart((int) MyUtil.getUserId(session));
        double sum = 0;
        for(Map<String, Object> map : list) {
            sum += (Double)map.get("smallsum");
        }

        model.addAttribute("total", sum);
        model.addAttribute("cartlist", list);

        return "before/orderconfirm";
    }
}
