package com.lovo.service.impl;

import com.lovo.dao.IRoleDao;
import com.lovo.entity.RoleEntity;
import com.lovo.entity.RoleUserEntity;
import com.lovo.service.IRoleService;
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
