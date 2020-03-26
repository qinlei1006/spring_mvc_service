package com.lovo.sh.service;

import com.lovo.sh.entity.UserEntity;

import java.util.List;

public interface IUserService {

    public void saveUser(UserEntity userEntity);
    public void delete(UserEntity userEntity);
    void deleteId(String id);
    List<UserEntity> findAll();
    public void upbeat(UserEntity userEntity);
    public UserEntity find(String name);
    public List<UserEntity> findByAge(Object[] objects);
}
