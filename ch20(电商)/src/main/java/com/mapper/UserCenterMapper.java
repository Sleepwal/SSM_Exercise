package com.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

public interface UserCenterMapper {
	public List<Map<String, Object>> myOrder(Long bid);
	public List<Map<String, Object>> myFocus(Long bid);
	public List<Map<String, Object>> orderDetail(Long ordersn);
}
