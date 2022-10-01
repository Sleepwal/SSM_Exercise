package com.mapper;

import java.util.List;
import java.util.Map;

import com.pojo.Order;

public interface OrderMapper {
	public int addOrder(Order order);
	public int addOrderDetail(Map<String, Object> map);
	public List<Map<String, Object>> selectGoodsShop(Integer uid);
	public int updateStore(Map<String, Object> map);
	public int clear(Integer uid);
	public int pay(Integer ordersn);
}
