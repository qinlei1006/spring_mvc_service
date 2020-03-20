package com.lovo.hibernate.entity.many;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "m_sys_student")
public class MStudentEntity {
    @Id
    @Column(length = 32)
    @GenericGenerator(name = "msuuid",strategy = "uuid")
    @GeneratedValue(generator = "msuuid")
    private String studentId;

    @Column(length = 48)
    private String studentName;

    @ManyToMany(mappedBy = "studentSet")
    private Set<MTeacherEntity> teacherSet;


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

    public Set<MTeacherEntity> getTeacherSet() {
        return teacherSet;
    }

    public void setTeacherSet(Set<MTeacherEntity> teacherSet) {
        this.teacherSet = teacherSet;
    }
}
