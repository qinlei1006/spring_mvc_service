package com.lovo.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity  //被hibernate管理的标签
@Table(name = "sys_user")  //映射表
public class UserEntity {

    @Id
    private int  userId;
    private String userName;
    private String password;
    private int age;


    public UserEntity() {
    }

      public UserEntity(int userId, String userName, String password, int age) {
          this.userId = userId;
          this.userName = userName;
          this.password = password;
          this.age = age;
      }

      public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
