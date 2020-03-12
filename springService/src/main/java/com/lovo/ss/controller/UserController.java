package com.lovo.ss.controller;

import com.lovo.ss.entity.UserEntity;
import com.lovo.ss.entity.UserInfoEntity;
import com.lovo.ss.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService service;

@RequestMapping("test.lovo")
private String test(){
    return "ok";
}

    /**
     * 添加用户信息
     * @param userEntity
     */
    @RequestMapping("addUser.lovo")
    public void addUser(UserEntity userEntity){

        service.addUser(userEntity);
    }

    /**
     * 按照id查询用户信息
     * @return
     */
    @RequestMapping("findById.lovo/{userId}")
    public UserInfoEntity findById(@PathVariable Integer userId){
        System.out.println(userId);
      return   service.findById(userId);
    }

    /**
     * 添加用户信息
     * @param userInfoEntity
     */
    @RequestMapping("addUserInfo.lovo")
    public void addUserInfo(UserInfoEntity userInfoEntity){
        service.addUserInfo(userInfoEntity);
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @RequestMapping("findAll.lovo")
    public List<UserEntity> findAll(){
        return service.findAll();
    }
}
