package com.lovo.jpa.service.impl;

import com.lovo.jpa.dao.UserDao;
import com.lovo.jpa.dto.UserDto;
import com.lovo.jpa.entity.UserEntity;
import com.lovo.jpa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<UserEntity> getListByAge(int age) {
        return userDao.getListByAge(age);
    }

    @Override
    public List<UserEntity> findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public List<UserDto> findByDto(){
       return userDao.findByDto();
    }

    @Override
    public List<Map> findByMap() {
        return userDao.findByMap();
    }



}
