package com.springboot.mybatis.springbootmybatisdemo2.service;

import com.springboot.mybatis.springbootmybatisdemo2.dao.CommentMapper;
import com.springboot.mybatis.springbootmybatisdemo2.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    public List<CommentModel> select(int id){
        return this.commentMapper.select(id);
    }
    public int insert(CommentModel commentModel){
        System.out.println("comment插入数据"+commentModel.getComment_info());
        return this.commentMapper.insert(commentModel);
    }
}
