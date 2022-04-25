package com.example.playground.dao;

import com.example.playground.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommentDao {
    public Integer addComment(Comment comment);
}
