package com.lovo.controller;

import com.lovo.entity.UserEntity;
import com.lovo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

//    @Autowired
//    IUserService userService = null;

//    @RequestMapping("lovo.login")
//    public UserEntity login(String userName,String password){
//        System.out.println("访问来了");
////        return userService.login("名字1","密码1");
//        UserEntity userEntity = new UserEntity();
//        return userEntity;
//    }

    @RequestMapping("lovo.test")
    public String t(){
        return "ok";
    }

}
