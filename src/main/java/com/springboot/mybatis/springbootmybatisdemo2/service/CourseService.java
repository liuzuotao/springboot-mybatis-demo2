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
        //System.out.println("service调用成功");
        return courseMapper.select();
    }
    public List<coursemodel> selectid(int id){
        return courseMapper.selectid(id);
    }
    public int update(int id,String StarLevel){

        List<coursemodel> a=courseMapper.select();
        coursemodel Res=null;
        for(int i=0;i<a.size();i++){
            if(a.get(i).getId()==id){
                Res=a.get(i);
                Res.setStar_level(StarLevel);
                courseMapper.update(Res);
                return 1;
            }
        }
        return 0;
    }
    public List<coursemodel> selectByName(String name){
        return courseMapper.selectByName(name);
    }
    public List<coursemodel> chooseSelect(String starLevel,String difficultyLevel){
        return courseMapper.chooseSelect(starLevel,difficultyLevel);
    }
}
