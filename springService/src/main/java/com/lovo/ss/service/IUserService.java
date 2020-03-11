package com.lovo.ss.service;

import com.lovo.ss.entit.UserEntity;
import com.lovo.ss.entit.UserInfoEntity;

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
    public UserEntity findById();

    /**
     * 添加用户信息
     * @param userInfoEntity
     */
    public void addUserInfo(UserInfoEntity userInfoEntity);

    public List<UserEntity>  findAll();

}
