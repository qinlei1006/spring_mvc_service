package com.lovo.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "sys_role")
public class RoleEntity {

    @Id
//    设置字符串长度
    @Column(length = 32)
//    自定义UUID
    @GenericGenerator(name = "roleId",strategy = "uuid")
//    给iD一个生产策勒，自定义生成策勒
    @GeneratedValue(generator = "roleId")
    private String roleId;
    private String roleName;

    public RoleEntity() {

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



}
