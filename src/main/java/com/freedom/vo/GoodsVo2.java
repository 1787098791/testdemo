package com.freedom.vo;

import java.io.Serializable;

public class GoodsVo2 implements Serializable {
    private String goodsName;
    private int minprice;
    private int maxprice;
    private String status;

    public GoodsVo2() {
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getMinprice() {
        return minprice;
    }

    public void setMinprice(int minprice) {
        this.minprice = minprice;
    }

    public int getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(int maxprice) {
        this.maxprice = maxprice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GoodsVo2{" +
                "goodsName='" + goodsName + '\'' +
                ", minprice=" + minprice +
                ", maxprice=" + maxprice +
                ", status='" + status + '\'' +
                '}';
    }
}
