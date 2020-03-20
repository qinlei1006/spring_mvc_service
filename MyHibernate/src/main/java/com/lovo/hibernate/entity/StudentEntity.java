package com.lovo.hibernate.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

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
    /**
     * fetch 表示加载方式
     * cascade 级联操作 all表示级联操作所有，删除主表会删除主表的记录慎用
     * 一般都用默认
     */
//    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
     @ManyToOne
     @JoinColumn(name = "f_t_id")
    private TeacherEntity teacher;

//    @OneToMany(mappedBy = "student")
//    @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//     private Set<TeacherEntity> teacherSet;


    public StudentEntity() {
    }

    public StudentEntity(String studentId, TeacherEntity teacher) {
        this.studentId = studentId;
        this.teacher = teacher;
    }

    public TeacherEntity getTeacherEntity() {
        return teacher;
    }

    public void setTeacherEntity(TeacherEntity teacherEntity) {
        this.teacher = teacherEntity;
    }

    public StudentEntity(String studentName) {
        this.studentName = studentName;
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

//    public TeacherEntity getTeacherEntity() {
//        return teacherEntity;
//    }
//
//    public void setTeacherEntity(TeacherEntity teacherEntity) {
//        this.teacherEntity = teacherEntity;
//    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +

                '}';
    }
}
