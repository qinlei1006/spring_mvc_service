package com.lovo.service.impl;

import com.lovo.dao.IGradeDao;
import com.lovo.entity.GradeEntity;
import com.lovo.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements IGradeService {

    @Autowired
    IGradeDao gradeDao;

    @Override
    public void saveList(List<GradeEntity> gradeEntityList) {
        gradeDao.saveAll(gradeEntityList);
    }

    @Override
    public List<GradeEntity>  findByGrade(String userId) {
        return gradeDao.findByGrade(userId);
    }
}
