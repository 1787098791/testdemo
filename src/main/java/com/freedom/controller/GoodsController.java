package com.freedom.controller;

import com.freedom.pojo.Message;
import com.freedom.service.GoodsService;
import com.freedom.vo.Goods;
import com.freedom.vo.GoodsVo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @ResponseBody
    @RequestMapping("selectAllGoods")
    public Object selectAllGoods(){
        List<Goods> goods = goodsService.selectAllGoods();
        return goods;
    }
    @RequestMapping("deleteByID")
    public String deleteByID(@RequestParam int id){
        int i = goodsService.deleteByID(id);
      return "goodsList.html";
    }
    @ResponseBody
    @RequestMapping("selectGoods")
    public Object selectGoods(@RequestBody GoodsVo2 goodsVo2){
        System.out.println(goodsVo2.getMaxprice());
        System.out.println(goodsVo2.getMinprice());
        List<Goods> goods = goodsService.selectGoods(goodsVo2);
        return goods;
    }
    @ResponseBody
    @RequestMapping("insertGoods")
    public Object insertGoods(@RequestBody Goods goods){
        int i = goodsService.insertGoods(goods);
        if (i==1){
            return true;
        }else{
            return false;
        }
    }
    @ResponseBody
    @RequestMapping("selectByID")
    public Object selectByID(@RequestParam int id){
        Goods goods = goodsService.selectByID(id);
        return goods;
    }

    @ResponseBody
    @RequestMapping("updateByID")
    public Object updateByID(@RequestBody Goods goods){
        int i = goodsService.updateByID(goods);
        if (i==1){
            return true;
        }else{
            return false;
        }
    }

}
