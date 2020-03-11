package com.lovo.ss.service.impl;

import com.lovo.ss.dao.IUserDao;
import com.lovo.ss.entit.UserEntity;
import com.lovo.ss.entit.UserInfoEntity;
import com.lovo.ss.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    private int userId;

    /**
     * 添加用户信息
     *
     * @param userEntity
     */
    public void addUser(UserEntity userEntity) {
        userDao.addUser(userEntity);
        userId =userEntity.getId();
        System.out.println(userId);

    }

    /**
     * 按照id查询用户信息
     * @return
     */
    public UserEntity findById() {
       int id = this.userId;
        return userDao.findById(id);
    }

    /**
     * 添加用户信息
     *
     * @param userInfoEntity
     */
    public void addUserInfo(UserInfoEntity userInfoEntity) {
        userDao.addUserInfo(userInfoEntity);
    }

    @Override
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }
}
