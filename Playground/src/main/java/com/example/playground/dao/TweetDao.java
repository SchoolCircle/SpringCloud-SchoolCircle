package com.example.playground.dao;

import com.example.playground.entity.Tweet;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TweetDao {
    public List<Tweet> findAll();

    List<Tweet> findAllWithType(Integer type);

    public int addTweet(Tweet tweet);

    public boolean existByTid(Integer tid);

    /**
     * 按照用户id查找,会返回已删除的帖子
     * 建议只能用户自己调用
     * @param uid
     * @return List
     */
    public List<Tweet> findAllTweetByUid(Integer uid);

    /**
     * 按照用户id查找，不会返回已删除的帖子
     * @param uid
     * @return List
     */
    public List<Tweet> findAliveTweetByUid(Integer uid);
}
