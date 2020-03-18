package com.lovo.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "sys_student")
public class StudentEntity {

    @Id
    //    设置字符串长度
    @Column(length = 32)
//    自定义UUID
    @GenericGenerator(name = "roleId",strategy = "uuid")
//    给iD一个生产策勒，自定义生成策勒
    @GeneratedValue(generator = "roleId")
    private String studentId;

    @Column(name = "s_name",length = 48)
    private String studentName;

    @ManyToOne
    @JoinColumn(name = "f_t_id")
    private TeacherEntity teacherEntity;

    public StudentEntity() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public TeacherEntity getTeacherEntity() {
        return teacherEntity;
    }

    public void setTeacherEntity(TeacherEntity teacherEntity) {
        this.teacherEntity = teacherEntity;
    }
}
