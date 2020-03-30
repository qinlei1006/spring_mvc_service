package com.lovo.dao;

import com.lovo.entity.RoleEntity;
import com.lovo.entity.RoleUserEntity;
import com.lovo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


public interface IRoleDao extends CrudRepository<RoleEntity,String> {

}
