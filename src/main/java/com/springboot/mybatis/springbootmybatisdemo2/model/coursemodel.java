package com.springboot.mybatis.springbootmybatisdemo2.model;

public class coursemodel {
    private int id;
    private String CourseName;
    private String DifficultyLevel;
    private String StarLevel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getDifficultyLevel() {
        return DifficultyLevel;
    }

    public void setDifficultyLecel(String difficultyLevel) {
        DifficultyLevel = difficultyLevel;
    }

    public String getStarLevel() {
        return StarLevel;
    }

    public void setStarLevel(String starLevel) {
        StarLevel = starLevel;
    }
}
