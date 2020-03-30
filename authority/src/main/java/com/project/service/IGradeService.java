package com.project.service;



import com.project.dto.UserGradeDto;
import com.project.entity.GradeEntity;

import java.util.List;


public interface IGradeService {
    void saveList(List<GradeEntity> userList);

    List<UserGradeDto>  findByGrade(String userId);

}
