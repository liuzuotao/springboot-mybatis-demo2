package com.springboot.mybatis.springbootmybatisdemo2.dao;

import com.springboot.mybatis.springbootmybatisdemo2.model.coursemodel;

import java.util.List;

public interface CourseMapper {
    List<coursemodel> select();
    int update(coursemodel cml);
}
