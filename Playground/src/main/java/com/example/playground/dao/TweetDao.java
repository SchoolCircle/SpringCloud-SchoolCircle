package com.example.playground.dao;

import com.example.playground.entity.Tweet;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TweetDao {
    public List<Tweet> findAll();

    public int addTweet(Tweet tweet);

    public boolean existByTid(Integer tid);
}
