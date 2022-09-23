package com.service;

import com.pojo.Goods;

import java.util.ArrayList;

public interface GoodsService {
    boolean save(Goods goods);
    ArrayList<Goods> getGoods();
}
