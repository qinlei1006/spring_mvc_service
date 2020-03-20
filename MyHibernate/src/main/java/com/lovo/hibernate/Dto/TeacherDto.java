package com.lovo.hibernate.Dto;

public class TeacherDto {

    private String teacherName;
    private String teacherClass;

    public TeacherDto() {
    }

    public TeacherDto(String teacherName, String teacherClass) {
        this.teacherName = teacherName;
        this.teacherClass = teacherClass;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(String teacherClass) {
        this.teacherClass = teacherClass;
    }
}
