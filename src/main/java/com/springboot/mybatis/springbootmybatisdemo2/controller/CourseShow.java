package com.springboot.mybatis.springbootmybatisdemo2.controller;

import com.springboot.mybatis.springbootmybatisdemo2.model.ChapterModel;
import com.springboot.mybatis.springbootmybatisdemo2.model.CommentModel;
import com.springboot.mybatis.springbootmybatisdemo2.service.ChapterService;
import com.springboot.mybatis.springbootmybatisdemo2.service.CommentService;
import com.springboot.mybatis.springbootmybatisdemo2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springboot.mybatis.springbootmybatisdemo2.model.coursemodel;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/test")
public class CourseShow {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("/CourseList")
    //@ResponseBody
    public String CourseListShow(Model model){
        List<coursemodel> course=courseService.select();
        model.addAttribute("Courses",course);
        return "CourseList";
    }

    @RequestMapping("/commentList/{id}")
    public String CommentListShow(Model model,@PathVariable(name = "id") int id){
        List<coursemodel> coursemodels=courseService.selectid(id);
        if(coursemodels.isEmpty())
            return null;
        else
            model.addAttribute("course",coursemodels.get(0));
        List<CommentModel> cmtlist= commentService.select(id);
        model.addAttribute("commentlist",cmtlist);
        return "Comment";
    }

    @RequestMapping("/chapter/{id}")
    public String ChapterListShow(Model model,@PathVariable(name = "id") int id){
        List<coursemodel> coursemodels=courseService.selectid(id);
        if(coursemodels.isEmpty())
            return null;
        else
            model.addAttribute("course",coursemodels.get(0));
        List<ChapterModel> chapterModels=chapterService.select(id);
        model.addAttribute("chapterList",chapterModels);

        return "Chapter";
    }
}
