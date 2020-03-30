package com.lovo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "sys_role_grade")
public class RoleGradeEntity {

    @Id
    @GenericGenerator(name = "ruuuid", strategy = "uuid")
    @GeneratedValue(generator = "ruuuid")
    @Column(name = "rg_id",length =32)
    private String egId;

    @ManyToOne
    @JoinColumn(name = "f_r_id")
    private RoleEntity role;

    @ManyToOne
    @JoinColumn(name = "f_g_id")
    private GradeEntity grade;

    public RoleGradeEntity() {
    }

    public RoleGradeEntity(RoleEntity role, GradeEntity grade) {
        this.role = role;
        this.grade = grade;
    }

    public String getEgId() {
        return egId;
    }

    public void setEgId(String egId) {
        this.egId = egId;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public GradeEntity getGrade() {
        return grade;
    }

    public void setGrade(GradeEntity grade) {
        this.grade = grade;
    }
}
