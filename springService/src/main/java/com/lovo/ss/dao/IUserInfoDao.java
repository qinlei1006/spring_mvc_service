package com.lovo.ss.dao;

import com.lovo.ss.entity.UserInfoEntity;

public interface IUserInfoDao {

    /**
     * 按照id查询用户信息
     * @param id
     * @return
     */
    public UserInfoEntity findById(int id);


}
