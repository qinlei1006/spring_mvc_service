package com.jpa;

import com.lovo.jpa.dao.BasicDao;
import com.lovo.jpa.dto.UserDto;
import com.lovo.jpa.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class JpaTest {

    BasicDao basicDao ;
    @Before
    public void test(){
        ClassPathXmlApplicationContext app =
                new ClassPathXmlApplicationContext("application.xml");
        basicDao = (BasicDao) app.getBean("basicDao");

    }

    @Test
    public void findListHQL(){
        List<UserEntity> list = basicDao.findListHQL();
        for (UserEntity u:list){
            System.out.println(u.getUserId()+"/"+u.getPassword()+"/"+u.getUserName());
        }
    }

    @Test
    public void findUserEntity(){
        UserEntity userEntity = basicDao.findUserEntity();
        System.out.println(userEntity.getUserId()+"/"+userEntity.getUserName()+"/"+userEntity.getAddDate());
    }

    @Test
    public void getListSql(){
        List<UserEntity> list = basicDao.getListSql();
        for (UserEntity u:list){
            System.out.println(u.getUserId()+"/"+u.getUserName());
        }
    }

    @Test
    public void findUser(){
        UserEntity userEntity = basicDao.findUser();
        System.out.println(userEntity.getUserName()+"/"+userEntity.getAddDate());
    }

    @Test
    public void findDto(){
        List<UserDto> list = basicDao.findDto();
       for (UserDto u:list){
           System.out.println(u.getUserName()+"/"+u.getUserAge());
       }
    }

    @Test
    public void findMap(){
        List<Map> list = basicDao.findMap();
       for (Map map:list){
           System.out.println(map.get("0")+"/"+map.get("1")+"/"+map.get("2"));
       }
    }

    @Test
    public  void getSql(){
        List<UserEntity> list = basicDao.getSql();
        for (UserEntity u:list){
            System.out.println(u.getUserId()+"/"+u.getAddDate());
        }
    }
    @Test
    public void getMapSql(){
        List<Map> list = basicDao.getMapSql();
        for (Map map : list){
            System.out.println(map.get("u_id")+"/"+map.get("u_name")+"/"+map.get("u_age")+"/"+map.get("u_password"));
        }
    }


}
