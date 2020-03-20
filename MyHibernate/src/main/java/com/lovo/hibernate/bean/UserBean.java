package com.lovo.hibernate.bean;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_user")
public class UserBean {

    @Id
    //设置表中列的属性
    @Column(length = 32)
    //自定义UUID
    @GenericGenerator(name = "roleuuid",strategy = "uuid")
    //给id一个生产策略,自定义生成策略
    @GeneratedValue(generator = "roleuuid")
    private String id;

    @Column(length = 48,name = "u_name")
    private String userName;

    @OneToMany(mappedBy = "user",cascade = javax.persistence.CascadeType.REFRESH)
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Set<RUBean> roleList;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<RUBean> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<RUBean> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +

                '}';
    }
}
