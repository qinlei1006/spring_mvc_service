package com.lovo.hibernate.entity.bean;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_role")
public class RoleEntity {

    @Id
    @Column(length = 32,name = "fk_roleId")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String roleId;
    @Column(length = 48,name = "r_name")
    private String roleName;
    @Column(length = 48,name = "r_info")
    private String roleInfo;
    @Column(length = 48,name = "r_state")
    private String roleState = "valid";

    @ManyToOne
    @JoinColumn(name = "pk_userId")
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private UserEntity user;

    @OneToMany(mappedBy = "role")
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<GradeEntity> gradeList;


    public RoleEntity() {
    }

    public RoleEntity(String roleName, String roleInfo,  List<GradeEntity> gradeList) {
        this.roleName = roleName;
        this.roleInfo = roleInfo;
        this.gradeList = gradeList;
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

    public String getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(String roleInfo) {
        this.roleInfo = roleInfo;
    }

    public String getRoleState() {
        return roleState;
    }

    public void setRoleState(String roleState) {
        this.roleState = roleState;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<GradeEntity> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<GradeEntity> gradeList) {
        this.gradeList = gradeList;
    }
}
