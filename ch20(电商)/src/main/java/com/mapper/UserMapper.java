package com.mapper;

import java.util.List;

import com.pojo.Buser;


public interface UserMapper {
	public int register(Buser buser);
	public List<Buser> login(Buser buser);
}
