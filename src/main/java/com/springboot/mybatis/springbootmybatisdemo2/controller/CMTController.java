package com.springboot.mybatis.springbootmybatisdemo2.controller;

import com.springboot.mybatis.springbootmybatisdemo2.model.CommentModel;
import com.springboot.mybatis.springbootmybatisdemo2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CMTController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/commentselect")
    public int select(){
        System.out.println("select被调用");
        List<CommentModel> a=commentService.select(1);
        for(int i=0;i<a.size();i++){
            CommentModel b=a.get(i);
            System.out.println(b.getId()+"  "+b.getStar_level()+"  "+b.getComment_info());
            b.setId(4);
            b.setStar_level("5星");
            commentService.insert(b);
        }
        return 0;
    }
}
