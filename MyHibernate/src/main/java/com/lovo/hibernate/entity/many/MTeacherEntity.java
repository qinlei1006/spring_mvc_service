package com.lovo.hibernate.entity.many;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "m_sys_teacher")
public class MTeacherEntity {

    @Id
    @Column(length = 48)
    @GenericGenerator(name = "mtuuid",strategy = "uuid")
    @GeneratedValue(generator = "mtuuid")
    private String teacherId;
    private String teacherName;

    @ManyToMany
    @JoinTable(name = "m_s_t",joinColumns = {@JoinColumn(name = "t_id")},
    inverseJoinColumns = {@JoinColumn(name = "s_id")})
    private Set<MStudentEntity> studentSet;

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

    public Set<MStudentEntity> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<MStudentEntity> studentSet) {
        this.studentSet = studentSet;
    }
}
