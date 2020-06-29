package com.springboot.mybatis.springbootmybatisdemo2.service;

import com.springboot.mybatis.springbootmybatisdemo2.dao.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.mybatis.springbootmybatisdemo2.model.coursemodel;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;//会报错，不用管

    public List<coursemodel> select(){
        return courseMapper.select();
    }
    public int update(String name,String StarLevel){
        List<coursemodel> a=courseMapper.select();
        coursemodel Res=null;
        for(int i=0;i<a.size();i++){
            if(a.get(i).getCourseName().equals(name)){
                Res=a.get(i);
                Res.setStarLevel(StarLevel);
                courseMapper.update(Res);
                return 1;
            }
        }
        return 0;
    }
}
