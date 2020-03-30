package com.project.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys_user")
public class UserEntity {

    @Id
    @GenericGenerator(name = "uuid",strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(length = 32,name = "u_id")
    private String userId;

    @Column(length = 48,name = "u_name")
    private String userName;

    @Column(length = 28,name = "u_password")
    private String password;

    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
   private List<RoleUserEntity> roleUserList;


    public UserEntity(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public List<RoleUserEntity> getRoleUserList() {
        return roleUserList;
    }

    public void setRoleUserList(List<RoleUserEntity> roleUserList) {
        this.roleUserList = roleUserList;
    }

    public UserEntity() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
