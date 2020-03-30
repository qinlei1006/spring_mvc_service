package com.lovo.service;

import com.lovo.entity.GradeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IGradeService {
    void saveList(List<GradeEntity> userList);

     List<GradeEntity>  findByGrade(String userId);

}
