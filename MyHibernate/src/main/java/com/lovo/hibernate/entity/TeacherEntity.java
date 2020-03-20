package com.lovo.hibernate.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Cascade;

import java.util.Set;

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

    /**
     * mappedBy 表示有一对一发一方来维护，值应该为对方的对象变量
     * cascade = CascadeType.PERSIST jp的级联保存
     *  @Cascade(value={CascadeType.SAVE_UPDATE}) hibernate的级联保存
     */
    @OneToMany(mappedBy = "teacher",cascade = javax.persistence.CascadeType.REFRESH)
    @Cascade(value={CascadeType.SAVE_UPDATE})
    private Set<StudentEntity> studentSet;




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

    public Set<StudentEntity> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<StudentEntity> studentSet) {
        this.studentSet = studentSet;
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherClass='" + teacherClass + '\'' +

                '}';
    }
}
