package com.lovo.ss.service.impl;

import com.lovo.ss.dao.IGoodsDao;
import com.lovo.ss.dao.IOrderDao;
import com.lovo.ss.entity.OrderEntity;
import com.lovo.ss.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "orderService")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Autowired
    private IGoodsDao goodsDao;

    /**
     * 添加订单 同时减少库存数量
     *
     * @param orderEntity
     */
    @Override
    public void addOrder(OrderEntity orderEntity) {

        orderDao.addOrder(orderEntity);
        int goodsId = orderEntity.getGoodsEntity().getGoodsId();
        int number = goodsDao.findById(goodsId)-1;

        goodsDao.UpdateNumber(goodsId,number);

    }
}
