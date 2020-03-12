package com.lovo.ss.entity;

public class OrderEntity {
    /**
     * 订单id
     */
    private int orderId;
    /**
     * 出售的价钱
     */
    private double price;
    /**
     * 厂库中商品对象
     */
    private GoodsEntity goodsEntity;

    public OrderEntity() {
    }

    public OrderEntity(double price, int goodsId) {
        this.price = price;
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setGoodsId(goodsId);
        this.goodsEntity = goodsEntity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public GoodsEntity getGoodsEntity() {
        return goodsEntity;
    }

    public void setGoodsEntity(GoodsEntity goodsEntity) {
        this.goodsEntity = goodsEntity;
    }
}
