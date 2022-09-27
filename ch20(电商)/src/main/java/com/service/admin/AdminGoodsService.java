package com.service.admin;

import com.pojo.Goods;

import javax.servlet.http.HttpServletRequest;

public interface AdminGoodsService {
    String addOrUpdateGoods(Goods goods, HttpServletRequest request, String updateAct);
}
