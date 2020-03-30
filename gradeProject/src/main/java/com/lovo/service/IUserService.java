package com.lovo.service;

import com.lovo.entity.UserEntity;

import java.util.List;

public interface IUserService {

    /**
     * 添加用户
     * @param userList
     */
    void saveList(List<UserEntity> userList);

    /**
     * 按照名字和密码查询用户
     * @param name
     * @param password
     * @return
     */
    public  UserEntity login(String name ,String password);
}
