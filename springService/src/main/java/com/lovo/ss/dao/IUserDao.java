package com.lovo.ss.dao;

import com.lovo.ss.entit.UserEntity;
import com.lovo.ss.entit.UserInfoEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserDao {

    /**
     * 添加用户信息
     * @param userEntity
     */
     @Insert("insert into t_user(userName,password,age)values(#{userName},#{password},#{age})")
     @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public void addUser(UserEntity userEntity);

    /**
     * 按照id查询用户信息
     * @param id
     * @return
     */
    public UserEntity findById(int id);

    /**
     * 添加用户信息
     * @param userInfoEntity
     */
    @Insert("insert into t_userinfo(post,salary,time,userId)values(#{post},#{salary},#{time},#{userEntity.id})")
    public void addUserInfo(UserInfoEntity userInfoEntity);


    /**
     * 查询所有用户
     * @return
     */
    public List<UserEntity> findAll();
}
