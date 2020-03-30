package com.project.dto;

public class UserGradeDto {

    private String userName;
    private String gradeUrl;
    private String gradeName;

    public UserGradeDto() {
    }

    public UserGradeDto(String userName, String gradeUrl, String gradeName) {
        this.userName = userName;
        this.gradeUrl = gradeUrl;
        this.gradeName = gradeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGradeUrl() {
        return gradeUrl;
    }

    public void setGradeUrl(String gradeUrl) {
        this.gradeUrl = gradeUrl;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}
