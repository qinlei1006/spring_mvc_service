package com.lovo.hibernate.entity.bean;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_grade")
public class GradeEntity {

    @Id
    @Column(length = 32,name = "fk_gradeId")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String gradeId;
    @Column(length = 48,name = "g_name")
    private String gradeName;
    @Column(length = 48,name = "g_resource")
    private String gradeResource;

    @ManyToOne
    @JoinColumn(name = "pk_roleId")
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private RoleEntity role;

    public GradeEntity() {
    }

    public GradeEntity(String gradeName, String gradeResource) {
        this.gradeName = gradeName;
        this.gradeResource = gradeResource;

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

    public String getGradeResource() {
        return gradeResource;
    }

    public void setGradeResource(String gradeResource) {
        this.gradeResource = gradeResource;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
