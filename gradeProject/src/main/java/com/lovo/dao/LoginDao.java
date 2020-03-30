package com.lovo.dao;

import com.lovo.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LoginDao extends CrudRepository<UserEntity,String> {

    @Query("from UserEntity where userName = ?1 and password =?2 ")
     UserEntity login(String name ,String password);

}
