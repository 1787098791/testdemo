package com.freedom.mapper;

import com.freedom.vo.Goods;
import com.freedom.vo.GoodsVo2;

import java.util.List;

public interface GoodsMapper {
    /**
     * 查询所有商品
     * @return
     */
     List<Goods> selectAllGoods();

    /**
     * 根据ID删除商品
     * @param id
     * @return
     */
     int deleteByID(int id);

    /**
     * 不定项查询
     * @param goodsVo2
     * @return
     */
    List<Goods> selectGoods(GoodsVo2 goodsVo2);

    /**
     * 增加商品
     * @param goods
     * @return
     */
    int insertGoods(Goods goods);

    Goods selectByID(int id);

    int updateByID(Goods goods);
}
