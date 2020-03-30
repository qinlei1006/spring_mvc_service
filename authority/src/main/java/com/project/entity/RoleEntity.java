package com.project.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys_role")
public class RoleEntity {
    @Id
    @GenericGenerator(name = "uuid",strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(length = 32,name = "u_id")
    private String roleId;

    @Column(name = "r_name",length = 48)
    private String roleName;

    @OneToMany(mappedBy = "user")
    private List<RoleUserEntity> roleUserEntityList;

    @OneToMany(mappedBy = "grade")
    private List<RoleGradeEntity> roleGradeList;

    public List<RoleGradeEntity> getRoleGradeList() {
        return roleGradeList;
    }

    public void setRoleGradeList(List<RoleGradeEntity> roleGradeList) {
        this.roleGradeList = roleGradeList;
    }

    public RoleEntity() {
    }

    public RoleEntity(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<RoleUserEntity> getRoleUserEntityList() {
        return roleUserEntityList;
    }

    public void setRoleUserEntityList(List<RoleUserEntity> roleUserEntityList) {
        this.roleUserEntityList = roleUserEntityList;
    }
}
