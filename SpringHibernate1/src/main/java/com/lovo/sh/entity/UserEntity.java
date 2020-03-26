package com.lovo.sh.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity  //被hibernate管理的标签
@Table(name = "sys_user")  //映射表
public class UserEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid",strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(length = 32,name = "u_id")
    private String  userId;
//    name列名，length长度，nullable是否可以为空
    @Column(name = "u_name",length = 48,nullable = false)
    private String userName;

//    insertable  = false 表示添加的时候不把数据添加到数据库
//    @Column(insertable = false,length = 48,name = "u_password")
//    不与表进行映射（冗余字段）
//    @Transient //暂态
    @Column(length = 48,name = "u_password")
    private String password;

//   将java不认识的时间字符串转为数据时间
    @Column(columnDefinition = "TIMESTAMP",name = "u_addDate")
    private String addDate;

//    定义文本数据
    @Column(columnDefinition = "TEXT",name = "u_info")
    private String info;

    @Column(name = "u_age")
    private int age;

    public UserEntity(String userName, String password, String addDate, String info, int age) {
        this.userName = userName;
        this.password = password;
        this.addDate = addDate;
        this.info = info;
        this.age = age;
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

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
