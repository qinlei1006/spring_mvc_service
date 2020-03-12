package com.lovo.ss.service.impl;

import com.lovo.ss.dao.IUserDao;
import com.lovo.ss.dao.IUserInfoDao;
import com.lovo.ss.entity.UserEntity;
import com.lovo.ss.entity.UserInfoEntity;
import com.lovo.ss.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUserInfoDao userInfoDao;

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
    public UserInfoEntity findById(int userId) {

        return userInfoDao.findById(userId);
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

    public List<UserEntity> affair(UserEntity userEntity){
        userDao.addUser(userEntity);
        return userDao.findAll();
    }
}
