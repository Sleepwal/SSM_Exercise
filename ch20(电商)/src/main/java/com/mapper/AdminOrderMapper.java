package com.mapper;

import java.util.List;
import java.util.Map;

public interface AdminOrderMapper {
    List<Map<String, Object>> orderInfo();
    int deleteOrderDetail(Long id);
    int deleteOrderBase(Long id);
}
