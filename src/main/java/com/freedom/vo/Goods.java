package com.freedom.vo;

import java.io.Serializable;

public class Goods  implements Serializable {
    private int id;
    private String goodsTitle;
    private String goodsName;
    private int basePrice;
    private int price;
    private int costPrice;
    private int stockNum;
    private String goodsDesc;
    private int goodsHot;
    private String status;
    private String goodsType;

    public Goods() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getBasePrice() {
        return basePrice/100;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getPrice() {
        return price/100;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCostPrice() {
        return costPrice/100;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public int getStockNum() {
        return stockNum;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public int getGoodsHot() {
        return goodsHot;
    }

    public void setGoodsHot(int goodsHot) {
        this.goodsHot = goodsHot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", basePrice=" + basePrice +
                ", price=" + price +
                ", costPrice=" + costPrice +
                ", stockNum=" + stockNum +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", goodsHot=" + goodsHot +
                ", status='" + status + '\'' +
                ", goodsType='" + goodsType + '\'' +
                '}';
    }
}
