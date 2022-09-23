package com.controller;

import com.mybatis.OrdersMapper;
import com.po.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class More2MoreController {
    @Autowired
    private OrdersMapper ordersMapper;

    public void test() {
        List<Orders> os = ordersMapper.selectAllOrdersAndProducts();
        os.forEach(System.out::println);
    }
}
