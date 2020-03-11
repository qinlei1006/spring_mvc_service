package com.lovo.ss.controller;

import com.lovo.ss.entit.UserEntity;
import com.lovo.ss.entit.UserInfoEntity;
import com.lovo.ss.service.IUserService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping("findById.lovo")
    public UserEntity findById(){
      return   service.findById();
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
