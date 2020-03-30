package com.project.service.impl;


import com.project.dao.IRoleDao;
import com.project.entity.RoleEntity;
import com.project.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    IRoleDao roleDao;

    @Override
    public void saveList(List<RoleEntity> roleList) {
        roleDao.saveAll(roleList);
    }
}
