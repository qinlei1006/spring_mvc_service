package com.project.entity;

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

    @Column(name = "g_url",length = 48)
    private String gradeUrl;

    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    private List<RoleGradeEntity> roleGradeList;

    public GradeEntity() {
    }

    public List<RoleGradeEntity> getRoleGradeList() {
        return roleGradeList;
    }

    public String getGradeUrl() {
        return gradeUrl;
    }

    public GradeEntity(String gradeId, String gradeUrl) {
        this.gradeId = gradeId;
        this.gradeUrl = gradeUrl;
    }

    public void setGradeUrl(String gradeUrl) {
        this.gradeUrl = gradeUrl;
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
