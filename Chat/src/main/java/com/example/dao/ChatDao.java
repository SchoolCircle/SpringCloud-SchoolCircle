package com.example.dao;

import com.example.entity.Chat;
import com.example.entity.query.ChatQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ChatDao {
    //查询所有记录
    public List<Chat> findAllChat();

//    //根据用户id查询
    public List<Chat> findByUid2(ChatQuery chatQuery);
}
