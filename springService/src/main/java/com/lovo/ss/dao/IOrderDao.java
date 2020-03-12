package com.lovo.ss.dao;

import com.lovo.ss.entity.OrderEntity;

/**
 * 订单持久层接口
 */
public interface IOrderDao {

    /**
     * 添加订单
     * @param orderEntity
     */
    public void addOrder(OrderEntity orderEntity);
}
