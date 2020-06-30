package com.springboot.mybatis.springbootmybatisdemo2.dao;

import com.springboot.mybatis.springbootmybatisdemo2.model.coursemodel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

public interface CourseMapper {
    List<coursemodel> select();
    List<coursemodel> selectid(int id);
    int update(coursemodel cml);
}
