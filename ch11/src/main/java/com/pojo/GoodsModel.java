package com.pojo;

public class GoodsModel {
    private String goodsname;
    private double goodsprice;
    private int goodsnumber;

    public GoodsModel() {
    }

    public GoodsModel(String goodsname, double goodsprice, int goodnumber) {
        this.goodsname = goodsname;
        this.goodsprice = goodsprice;
        this.goodsnumber = goodnumber;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public int getGoodsnumber() {
        return goodsnumber;
    }

    public void setGoodsnumber(int goodsnumber) {
        this.goodsnumber = goodsnumber;
    }
}
