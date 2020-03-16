package com.lovo.ss.service.impl;

import com.lovo.ss.dao.IGoodsDao;
import com.lovo.ss.entity.GoodsEntity;
import com.lovo.ss.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "goodsService")
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private IGoodsDao goodsDao;
    @Override
    public void add(GoodsEntity goodsEntity) {
        goodsDao.add(goodsEntity);
    }
}
