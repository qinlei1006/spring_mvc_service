package com.lovo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys_grade")
public class GradeEntity {

    @Id
    @GenericGenerator(name = "uuid",strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(length = 32,name = "g_id")
    private String gradeId;

    @Column(name = "g_name",length = 48)
    private String gradeName;

    @OneToMany(mappedBy = "role")
    private List<RoleGradeEntity> roleGradeList;

    public GradeEntity() {
    }

    public List<RoleGradeEntity> getRoleGradeList() {
        return roleGradeList;
    }

    public void setRoleGradeList(List<RoleGradeEntity> roleGradeList) {
        this.roleGradeList = roleGradeList;
    }

    public GradeEntity(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}
