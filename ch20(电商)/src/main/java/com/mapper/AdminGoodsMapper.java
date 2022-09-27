package com.mapper;

import com.pojo.Goods;

import java.util.List;
import java.util.Map;

/**
 * @package: com.mapper
 * @className: AdminGoodsMapper
 * @author: SleepWalker
 * @description: TODO
 * @date: 17:46
 * @version: 1.0
 */
public interface AdminGoodsMapper {
    List<Goods> selectGoods();
    List<Goods> selectAllGoodsByPage(Map<String, Object> map);
    int addGoods(Goods goods);
    Goods selectGoodsById(long id);
    int deleteGoods(List<Long> ids);
    int deleteAGoods(long id);
    int updateGoodsById(Goods goods);

    List<Map<String, Object>> selectCartGoods(long id);
    List<Map<String, Object>> selectFocusGoods(long id);
    List<Map<String, Object>> selectOrderdetailGoods(long id);

}
