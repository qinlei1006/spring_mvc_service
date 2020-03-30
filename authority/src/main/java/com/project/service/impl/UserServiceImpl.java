package com.project.service.impl;


import com.project.dao.LoginDao;
import com.project.entity.UserEntity;
import com.project.service.IUserService;
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
