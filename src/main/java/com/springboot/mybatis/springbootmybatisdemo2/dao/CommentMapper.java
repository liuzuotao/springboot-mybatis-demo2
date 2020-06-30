package com.springboot.mybatis.springbootmybatisdemo2.dao;

import com.springboot.mybatis.springbootmybatisdemo2.model.CommentModel;

import java.util.List;

public interface CommentMapper {
    List<CommentModel> select(int id);
    int insert(CommentModel commentModel);
}
