package com.lovo.jpa.dao;

import com.lovo.jpa.dto.UserDto;
import com.lovo.jpa.entity.UserEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface UserDao extends CrudRepository<UserEntity,String> {

    @Query("from UserEntity where age > ?1")
    public List<UserEntity> getListByAge(int age);

    @Query("from UserEntity  WHERE userName like :name")
    public List<UserEntity> findByName(@Param("name") String name);

    @Query("select new com.lovo.jpa.dto.UserDto(userName,age) from UserEntity")
    public List<UserDto> findByDto();

    @Query("select new map(userName,password,strDate) from UserEntity")
    public List<Map> findByMap();

    @Query("from UserEntity where age > ?1 ")
    public  List<UserEntity> getPageList(int age, PageRequest request);


}
