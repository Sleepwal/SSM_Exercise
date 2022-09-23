package com.service;

import com.pojo.Goods;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GoodsServiceImpl implements GoodsService {
    //使用静态变量模拟数据库
    private static ArrayList<Goods> goods = new ArrayList<>();

    @Override
    public boolean save(Goods g) {
        goods.add(g);
        return true;
    }

    @Override
    public ArrayList<Goods> getGoods() {
        return goods;
    }
}
