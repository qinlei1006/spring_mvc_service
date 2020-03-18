package com.lovo.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "sys_teacher")
public class TeacherEntity {

    @Id
    //    设置字符串长度
    @Column(length = 32)
//    自定义UUID
    @GenericGenerator(name = "roleId",strategy = "uuid")
//    给iD一个生产策勒，自定义生成策勒
    @GeneratedValue(generator = "roleId")
    private String teacherId;

    @Column(name = "t_name",length = 48)
    private String teacherName;

    @Column(name = "t_class",length = 48)
    private String teacherClass;


    public String getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(String teacherClass) {
        this.teacherClass = teacherClass;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
