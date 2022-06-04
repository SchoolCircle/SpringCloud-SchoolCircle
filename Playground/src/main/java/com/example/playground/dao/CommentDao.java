package com.example.playground.dao;

import com.example.playground.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentDao {
    public Integer addComment(Comment comment);

    public List<Comment> findCommentsByTid(Integer tid);

    public List<Comment> findCommentsByUid(Integer uid);
}
