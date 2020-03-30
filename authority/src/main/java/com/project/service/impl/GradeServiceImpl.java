package com.project.service.impl;

import com.project.dao.IGradeDao;
import com.project.dto.UserGradeDto;
import com.project.entity.GradeEntity;
import com.project.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "gradeService")
public class GradeServiceImpl implements IGradeService {

    @Autowired
    IGradeDao gradeDao;

    @Override
    public void saveList(List<GradeEntity> gradeEntityList) {
        gradeDao.saveAll(gradeEntityList);
    }

    @Override
    public List<UserGradeDto> findByGrade(String userId) {
       List<Object[]> objects = gradeDao.findByGrade(userId);
       List<UserGradeDto> userGradeDtoList = new ArrayList<>();
       if (objects != null && objects.size() > 0){
           for (Object[] obj: objects){
               UserGradeDto u = new UserGradeDto();
               u.setUserName(obj[0].toString());
               u.setGradeName(obj[1].toString());
               u.setGradeUrl(obj[2].toString());
               userGradeDtoList.add(u);
           }
       }
       return userGradeDtoList;
    }
}
