package com.lovo.jpa.service;

import com.lovo.jpa.dto.UserDto;
import com.lovo.jpa.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface IUserService {

    public List<UserEntity> getListByAge(int age);

    public List<UserEntity> findByName( String name);

    public List<UserDto> findByDto();

    public List<Map> findByMap();
}
