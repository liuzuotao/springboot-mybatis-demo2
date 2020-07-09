package com.springboot.mybatis.springbootmybatisdemo2.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.mybatis.springbootmybatisdemo2.model.ChapterModel;
import com.springboot.mybatis.springbootmybatisdemo2.model.CommentModel;
import com.springboot.mybatis.springbootmybatisdemo2.service.ChapterService;
import com.springboot.mybatis.springbootmybatisdemo2.service.CommentService;
import com.springboot.mybatis.springbootmybatisdemo2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.springboot.mybatis.springbootmybatisdemo2.model.coursemodel;

import javax.jws.WebParam;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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
    public String CourseListShow(Model model){//查询书籍信息数组
        List<coursemodel> course=courseService.select();
        model.addAttribute("Courses",course);
        return "CourseList";
    }
    @RequestMapping("/Search")
    public String SearchCourse(Model model,String text){//根据书名实现模糊查询返回结果数组
        //使用动态sql语句实现模糊查询
        List<coursemodel> result=courseService.selectByName(text);
        if(result==null)
            System.out.println("未查询到数据");
        model.addAttribute("Courses",result);
        model.addAttribute("txt",text);
        return "CourseList";
    }
    @RequestMapping("/SearchByStarOrDif")
    public String SearchByStarOrDif(Model model,String starLevel,String difficultyLevel){
        System.out.println("星级："+starLevel+"难度等级"+difficultyLevel);
        List<coursemodel> result=courseService.chooseSelect(starLevel,difficultyLevel);
        model.addAttribute("starLevel",starLevel);
        model.addAttribute("difficultyLevel",difficultyLevel);
        model.addAttribute("Courses",result);
        return "CourseList";
    }
    @RequestMapping("/commentList/{id}")
    public String CommentListShow(Model model,@PathVariable(name = "id") int id){//获取评论列表
        List<coursemodel> coursemodels=courseService.selectid(id);
        if(coursemodels.isEmpty())
            return null;
        else
            model.addAttribute("course",coursemodels.get(0));
        List<CommentModel> cmtlist= commentService.select(id);
        model.addAttribute("commentlist",cmtlist);
        return "Comment";
    }

    @RequestMapping("/recrivecomment")
    @ResponseBody
    public String ReceiveComment(@RequestBody String data){//AJAX传入评论数据
        JSONObject jsonObject=JSONObject.parseObject(data);

        int id=Integer.parseInt(jsonObject.get("id").toString());
        System.out.println(id);
        String starLevel=jsonObject.get("starLevel").toString();
        String cmtInfo=jsonObject.get("cmtInfo").toString();
        //数据库插入数据
        CommentModel commentModel=new CommentModel();
        commentModel.setId(id);
        commentModel.setStar_level(starLevel);
        commentModel.setComment_info(cmtInfo);
        commentService.insert(commentModel);

        //读取星级取平均数修改课程星级数据
        List<CommentModel> commentModels=commentService.select(id);
        double Starnum=0.0;
        Pattern pattern = Pattern.compile("[^0-9]");
        for(int i=0;i<commentModels.size();i++){
            String sL=commentModels.get(i).getStar_level();
            String slnum=pattern.matcher(sL).replaceAll("");
            Starnum+=Integer.parseInt(slnum);
            System.out.println("星数总和"+Starnum);
        }
        double average=Starnum/commentModels.size()*1.0;
        System.out.println("修改前的平均数"+average);
        average= (new BigDecimal(average)).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
        String starAverage=String.valueOf(average)+"星";
        System.out.println("修改后的星数"+starAverage);
        courseService.update(id,starAverage);

        JSONObject json=new JSONObject();
        json.put("coursestarLevel",starAverage);
        json.put("starLevel",commentModel.getStar_level());
        json.put("cmtInfo",commentModel.getComment_info());
        String jsonstring= JSON.toJSONString(json);
        System.out.println(jsonstring);
        return jsonstring;
    }

    @RequestMapping("/chapter/{id}")
    public String ChapterListShow(Model model,@PathVariable(name = "id") int id){//根据书籍的id主键获取章节列表信息
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
