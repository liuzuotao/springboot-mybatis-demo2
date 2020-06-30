package com.springboot.mybatis.springbootmybatisdemo2.model;

public class ChapterModel {
    private int id;
    private int chapterNum;
    private String capterInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(int chapterNum) {
        this.chapterNum = chapterNum;
    }

    public String getCapterInfo() {
        return capterInfo;
    }

    public void setCapterInfo(String capterInfo) {
        this.capterInfo = capterInfo;
    }
}
