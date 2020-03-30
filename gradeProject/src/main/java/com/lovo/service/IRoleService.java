package com.lovo.service;

import com.lovo.entity.RoleEntity;
import com.lovo.entity.RoleUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IRoleService {
    void saveList(List<RoleEntity> roleList);
}
