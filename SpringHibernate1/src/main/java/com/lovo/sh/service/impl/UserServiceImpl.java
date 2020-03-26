package com.lovo.sh.service.impl;

import com.lovo.sh.dao.UserDao;
import com.lovo.sh.entity.UserEntity;
import com.lovo.sh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userService")
@Transactional(rollbackFor = {Exception.class})
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDao userDao;

    @Override
    public void saveUser(UserEntity userEntity) {
      userDao.saveObject(userEntity);
    }

    @Override
    public void delete(UserEntity userEntity) {
        userDao.delete(userEntity);
    }

    @Override
    public void deleteId(String id) {
       userDao.deleteId(id);
    }



    @Override
    public void upbeat(UserEntity userEntity) {
        userDao.update(userEntity);
    }

    @Override
    public UserEntity find(String name) {

        return (UserEntity) userDao.findObj(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity>  findByAge(Object[] objects) {
        String hql = " from  UserEntity where age > ? or userName like ? ";
        return userDao.getListArray(hql,objects);
    }




}
