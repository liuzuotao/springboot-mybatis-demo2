package com.springboot.mybatis.springbootmybatisdemo2.dao;

import com.springboot.mybatis.springbootmybatisdemo2.model.coursemodel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

public interface CourseMapper {
    List<coursemodel> select();
    List<coursemodel> selectid(int id);
    List<coursemodel> selectByName(@Param("name") String name);//mybatis if动态sql语句实现课程名字模糊查询
    int update(coursemodel cml);
    List<coursemodel> chooseSelect(@Param("starLevel") String starLevel,@Param("difficultyLevel") String difficultyLevel);
    //mybatis choose动态sql语句
}
