package com.mapper;

import com.pojo.Goods;

/**
 * @package: com.mapper
 * @className: AdminGoodsMapper
 * @author: SleepWalker
 * @description: TODO
 * @date: 17:46
 * @version: 1.0
 */
public interface AdminGoodsMapper {
    int addGoods(Goods goods);
    int updateGoodsById(Goods goods);
}
