package com.lovo.ss.service;

import com.lovo.ss.entity.OrderEntity;

/**
 * 订单业务层接口
 */
public interface IOrderService {

    /**
     * 添加订单 同时减少库存数量
     * @param orderEntity
     */
    public void  addOrder(OrderEntity orderEntity);
}
