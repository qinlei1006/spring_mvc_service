package com.project.dao;


import com.project.entity.GradeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IGradeDao extends CrudRepository<GradeEntity,String> {

    @Query(value = " SELECT distinct  u.u_name,g.g_name,g.g_url from sys_user u LEFT JOIN sys_role_user ru on u.u_id = ru.f_u_id \n" +
            "             JOIN sys_role r on ru.f_r_id = r.u_id\n" +
            "             JOIN sys_role_grade rg on r.u_id = rg.f_r_id \n" +
            "             JOIN sys_grade g ON  rg.f_g_id = g.g_id \n" +
            "           WHERE u.u_id = ?1 ",nativeQuery = true)
     List<Object[]> findByGrade(String userId);

}
