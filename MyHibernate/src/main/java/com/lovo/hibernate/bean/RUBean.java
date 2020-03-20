package com.lovo.hibernate.bean;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import sun.dc.pr.PRError;

import javax.persistence.*;

@Entity
@Table(name = "r_u_link")
public class RUBean {

    @Id
    //设置表中列的属性
    @Column(length = 32)
    //自定义UUID
    @GenericGenerator(name = "uuid",strategy = "uuid")
    //给id一个生产策略,自定义生成策略
    @GeneratedValue(generator = "uuid")
    private String id;


    @ManyToOne
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private RoleBean role;

    @ManyToOne
    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private UserBean user;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public RoleBean getRole() {
        return role;
    }

    public void setRole(RoleBean role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RUBean{" +
                "id='" + id + '\'' +
                ", role=" + role +
                ", user=" + user +
                '}';
    }
}
