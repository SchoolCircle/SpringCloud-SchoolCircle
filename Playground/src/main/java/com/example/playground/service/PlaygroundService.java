package com.example.playground.service;

import com.example.playground.dao.TweetDao;
import com.example.playground.entity.Result;
import com.example.playground.entity.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaygroundService {
    @Autowired
    private TweetDao tweetDao;

    public Result<List<Tweet>> findAll(){
        return new Result<>(tweetDao.findAll());
    }
}
