package com.lovo.hibernate.bean;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_role")
public class RoleBean {

    @Id
    //设置表中列的属性
    @Column(length = 32)
    //自定义UUID
    @GenericGenerator(name = "roleuuid",strategy = "uuid")
    //给id一个生产策略,自定义生成策略
    @GeneratedValue(generator = "roleuuid")
    private String id;

    @Column(length = 48,name = "r_name")
    private String roleName;


    @OneToMany(mappedBy = "role",cascade = javax.persistence.CascadeType.REFRESH)
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Set<RUBean> userList;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<RUBean> getUserList() {
        return userList;
    }

    public void setUserList(Set<RUBean> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "RoleBean{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
