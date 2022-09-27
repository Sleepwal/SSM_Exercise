package com.mapper;

import com.pojo.Goods;
import com.pojo.GoodsType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adminTypeDao")
@Mapper
public interface AdminTypeMapper {
	public List<GoodsType> selectGoodsType();
	public int addType(String typename);
	public int deleteType(long id);
	public List<Goods> selectGoodsByType(long id);
}
