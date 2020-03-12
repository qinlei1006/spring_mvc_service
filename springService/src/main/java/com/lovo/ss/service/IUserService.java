package com.lovo.ss.service;

import com.lovo.ss.entity.UserEntity;
import com.lovo.ss.entity.UserInfoEntity;

import java.util.List;

public interface IUserService {

    /**
     * 添加用户信息
     * @param userEntity
     */
    public void addUser(UserEntity userEntity);

    /**
     * 按照id查询用户信息
     * @return
     */
    public UserInfoEntity findById(int userId);

    /**
     * 添加用户信息
     * @param userInfoEntity
     */
    public void addUserInfo(UserInfoEntity userInfoEntity);

    public List<UserEntity>  findAll();

    public List<UserEntity> affair(UserEntity userEntity);

}
