package com.lovo.service.impl;

import com.lovo.dao.LoginDao;
import com.lovo.entity.UserEntity;
import com.lovo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    LoginDao loginDao;

    @Override
    public void saveList(List<UserEntity> userList) {
        loginDao.saveAll(userList);
    }

    /**
     * 按照名字和密码查询用户
     *
     * @param name
     * @param password
     * @return
     */
    @Override
    public  UserEntity login(String name, String password) {
        return loginDao.login(name,password);
    }



}
