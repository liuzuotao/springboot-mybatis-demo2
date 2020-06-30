package com.springboot.mybatis.springbootmybatisdemo2.service;

import com.springboot.mybatis.springbootmybatisdemo2.dao.ChapterMapper;
import com.springboot.mybatis.springbootmybatisdemo2.dao.CommentMapper;
import com.springboot.mybatis.springbootmybatisdemo2.model.ChapterModel;
import com.springboot.mybatis.springbootmybatisdemo2.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;
    public List<ChapterModel> select(int id){
        return chapterMapper.select(id);
    }
    public int insert(ChapterModel chapterModel){
        return chapterMapper.insert(chapterModel);
    }
}
