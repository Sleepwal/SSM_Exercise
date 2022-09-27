package com.service.admin;

import com.pojo.Goods;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface AdminGoodsService {
    String addOrUpdateGoods(Goods goods, HttpServletRequest request, String updateAct);
    public String selectAGoods(Model model, Long id, String act);
    public String deleteGoods(long[] ids, Model model);
    public String deleteAGoods(long id, Model model);
    public String selectGoods(Model model, Long pageCur, String act);
}
