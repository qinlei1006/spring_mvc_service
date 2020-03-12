package com.lovo.spring.vo;

import java.sql.Date;

public class UserInfoVo {
    private int id;
    private String post;
    private double salary;
    private Date time;
    private UserVo userEntity;

    public UserVo getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserVo userEntity) {
        this.userEntity = userEntity;
    }

    public UserInfoVo() {
    }

    public UserInfoVo(String post, double salary, Date time, int userId) {
        this.post = post;
        this.salary = salary;
        this.time = time;
        userEntity = new UserVo();
        userEntity.setId(userId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
