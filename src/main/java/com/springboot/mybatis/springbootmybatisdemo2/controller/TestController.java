package com.springboot.mybatis.springbootmybatisdemo2.controller;

import com.springboot.mybatis.springbootmybatisdemo2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.mybatis.springbootmybatisdemo2.model.coursemodel;

import java.util.List;

@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/courseselect")
    public int select(){
        //System.out.println("select调用成功");
        coursemodel res=null;
        List<coursemodel> a=this.courseService.select();
        for(int i=0;i<a.size();i++){
            res=a.get(i);
            System.out.println(res.getCourse_name()+"  "+res.getDifficulty_level()+"  "+res.getStar_level());
        }
        return 1;
    }

}
