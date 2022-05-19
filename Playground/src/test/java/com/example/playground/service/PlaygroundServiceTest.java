package com.example.playground.service;

import com.example.playground.entity.Result;
import com.example.playground.entity.Tweet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaygroundServiceTest {

    @Autowired
    private PlaygroundService playgroundService;
    @Test
    void findAll() {
        Result<List<Tweet>> result = playgroundService.findAll();
        System.out.println(result.getMsg());
        for(Tweet x:result.getData()){
            System.out.println(x.toString());
        }
    }

    //正确的情况
    @Test
    void findTweetByUidSuccess() {
        Result<List<Tweet>> result = playgroundService.findTweetByUid(2);
        System.out.println(result.getMsg());
        for(Tweet x:result.getData()){
            System.out.println(x.toString());
        }
    }

    @Test
    void findTweetByUidFail(){
        Result<List<Tweet>> result = playgroundService.findTweetByUid(5);//记录中没有5
        System.out.println(result.getMsg());
    }
    @Test
    void findMyTweet() {
        Result<List<Tweet>> result = playgroundService.findMyTweet(2,"uid=2");//正常情况
        System.out.println(result.getMsg());
        for(Tweet x:result.getData()){
            System.out.println(x.toString());
        }

        result = playgroundService.findMyTweet(2,"uid");//token错误
        System.out.println(result.getMsg());

        result = playgroundService.findMyTweet(5, "uid=2");//uid不对
        System.out.println(result.getMsg());

    }
}