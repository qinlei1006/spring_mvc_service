package com.lovo.ss.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 厂库持久接口
 */
public interface IGoodsDao {

    /**
     * 按照商品id修改商品库存
     */
    public void UpdateNumber(@Param("goodsId") int goodsId,@Param("number") int number);

    /**
     * 按照商品id查询商品库存数量
     * @param goodsId
     * @return
     */
    public int findById(int goodsId);
}
