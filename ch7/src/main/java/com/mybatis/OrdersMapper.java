package com.mybatis;

import com.po.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersMapper {
    List<Orders> selectOrdersById(Integer uid);
    List<Orders> selectAllOrdersAndProducts();
}
