package com.springboot.mybatis.springbootmybatisdemo2.controller;

import com.springboot.mybatis.springbootmybatisdemo2.model.ChapterModel;
import com.springboot.mybatis.springbootmybatisdemo2.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CAPController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/chapterselect")
    public int select(){
        System.out.println("select被调用");
        List<ChapterModel> a=chapterService.select(1);
        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i).getId()+"  "+a.get(i).getChapterNum()+"  "+a.get(i).getCapterInfo());
           
        }
        return 0;
    }

}
