package com.freedom.service.imp;

import com.freedom.mapper.GoodsMapper;
import com.freedom.pojo.Message;
import com.freedom.service.GoodsService;
import com.freedom.vo.Goods;
import com.freedom.vo.GoodsVo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImp implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    public List<Goods> selectAllGoods() {
        List<Goods> goods = goodsMapper.selectAllGoods();
        return goods;
    }

    public int deleteByID(int id) {
        int i = goodsMapper.deleteByID(id);
        return i;
    }

    public List<Goods> selectGoods(GoodsVo2 goodsVo2) {
       goodsVo2.setMinprice(goodsVo2.getMinprice()*100);
       goodsVo2.setMaxprice(goodsVo2.getMaxprice()*100);
        List<Goods> goods = goodsMapper.selectGoods(goodsVo2);
        return goods;
    }

    public int insertGoods(Goods goods) {
        goods.setBasePrice(goods.getBasePrice()*10000);
        goods.setPrice(goods.getPrice()*10000);
        goods.setCostPrice(goods.getCostPrice()*10000);
        int i = goodsMapper.insertGoods(goods);
        return i;
    }

    public Goods selectByID(int id) {
        Goods goods = goodsMapper.selectByID(id);
        return goods;
    }


    public int updateByID(Goods goods) {
        goods.setBasePrice(goods.getBasePrice()*10000);
        goods.setPrice(goods.getPrice()*10000);
        goods.setCostPrice(goods.getCostPrice()*10000);
        int i = goodsMapper.updateByID(goods);
        return i;
    }


}
