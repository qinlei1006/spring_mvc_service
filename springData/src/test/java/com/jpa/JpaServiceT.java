package com.jpa;

import com.lovo.jpa.dto.UserDto;
import com.lovo.jpa.entity.UserEntity;
import com.lovo.jpa.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class JpaServiceT {
    IUserService userService =null;

    @Before
    public void getContext(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");
        userService = (IUserService) context.getBean("userService");
    }

    @Test
    public void getListByAge(){
        List<UserEntity> list = userService.getListByAge(17);
        for (UserEntity u:list){
            System.out.println(u.getUserId()+"/"+u.getUserName());
        }
    }

    @Test
    public void findByName(){
        List<UserEntity> list = userService.findByName("%云%");
        for (UserEntity u:list){
            System.out.println(u.getUserId()+"/"+u.getUserName());
        }
    }

    @Test
    public void findByDto(){
        List<UserDto> list = userService.findByDto();
        for (UserDto u:list){
            System.out.println(u.getUserName()+"/"+u.getUserAge());
        }
    }

    @Test
    public void findByMap(){
        List<Map> list = userService.findByMap();
        for (Map m:list){
            System.out.println(m.get("0")+"/"+m.get("1")+"/"+m.get("2"));
        }
    }
}
