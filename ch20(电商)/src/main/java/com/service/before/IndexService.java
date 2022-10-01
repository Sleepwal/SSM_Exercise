package com.service.before;

import com.pojo.Goods;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface IndexService {
    String before(Model model, HttpSession session, Goods goods);
    String search(Model model, String mykey);
    String toRegister(Model model);
    String toLogin(Model model);
    String goodsDetail(Model model, Integer id);
}
