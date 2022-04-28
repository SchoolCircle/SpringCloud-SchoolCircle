package com.example.playground.service;

import com.example.playground.entity.Result;
import com.example.playground.entity.Tweet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PlaygroundServiceTest {
    @Autowired
    private PlaygroundService playgroundService;
//    @Test
//    void addTweet() {
//        Result<List<Tweet>> result = playgroundService.addTweet(2, "1233211234567","uid=2");
//
//        System.out.println("ok");
//    }
}