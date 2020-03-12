package com.lovo.ss.entity;

public class GoodsEntity {
    /**
     * 商品id
     */
    private int goodsId;
    /**
     * 商品名字
     */
    private String goodsName;
    /**
     * 商品数据量
     */
    private int number;

    public GoodsEntity() {
    }

    public GoodsEntity(String goodsName, int number) {
        this.goodsName = goodsName;
        this.number = number;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
