package com.mapper;

import com.pojo.Auser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    public List<Auser> login(Auser auser);
}
