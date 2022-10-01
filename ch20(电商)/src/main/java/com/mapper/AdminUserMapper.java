package com.mapper;

import java.util.List;
import java.util.Map;

public interface AdminUserMapper {
    List<Map<String, Object>> userInfo();
    int deleteUser(Long id);
}
