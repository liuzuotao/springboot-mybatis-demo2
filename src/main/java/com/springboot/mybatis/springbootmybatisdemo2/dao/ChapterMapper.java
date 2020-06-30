package com.springboot.mybatis.springbootmybatisdemo2.dao;

import com.springboot.mybatis.springbootmybatisdemo2.model.ChapterModel;

import java.util.List;

public interface ChapterMapper {
    List<ChapterModel> select(int id);
    int insert(ChapterModel chapterModel);
}
