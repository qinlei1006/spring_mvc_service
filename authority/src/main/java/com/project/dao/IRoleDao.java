package com.project.dao;


import com.project.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;


public interface IRoleDao extends CrudRepository<RoleEntity,String> {

}
