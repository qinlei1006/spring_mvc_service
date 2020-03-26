package com.lovo.hibernate.entity.bean;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_user")
public class UserEntity {
    @Id
    @Column(length = 32,name = "fk_userId")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String userID;
    @Column(length = 48,name = "u_name")
    private String userName;
    @Column(length = 48,name = "u_password")
    private String password;
    @Column(length = 48,name = "u_state")
    private String userState = "valid";

    @OneToMany(mappedBy = "user")
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<RoleEntity> roleList;

    public UserEntity() {
    }

    public UserEntity(String userName, String password,List<RoleEntity> roleList) {
        this.userName = userName;
        this.password = password;
        this.roleList = roleList;

    }

    public List<RoleEntity> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleEntity> roleList) {
        this.roleList = roleList;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }
}
