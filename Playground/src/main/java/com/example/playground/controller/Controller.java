package com.example.playground.controller;

import com.example.playground.entity.Comment;
import com.example.playground.entity.Result;
import com.example.playground.entity.Tweet;
import com.example.playground.entity.request.CommentRequest;
import com.example.playground.entity.request.TweetRequest;
import com.example.playground.service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private PlaygroundService playgroundService;


    @GetMapping("/findAll")//TODO 测试用，最终删除该接口
    public Result<List<Tweet>> findAll() {
        return playgroundService.findAll();
    }

    @PostMapping("/addTweet")//TODO 函数待验证
    public Result<List<Tweet>> addTweet(@RequestBody TweetRequest tweetRequest) {
        if (tweetRequest.getText() == null || tweetRequest.getToken() == null || tweetRequest.getUid() == null) {
            return new Result<>("传入参数不足", 201);
        }
        return playgroundService.addTweet(tweetRequest.getUid(), tweetRequest.getText(), tweetRequest.getToken());
    }

    @PostMapping("/addComment")//TODO 函数待验证
    public Result<List<Comment>> addComment(@RequestBody CommentRequest commentRequest) {
        if (commentRequest.getText() == null || commentRequest.getTid() == null
                || commentRequest.getToken() == null || commentRequest.toString() == null) {
            return new Result<>("传入参数不足", 201);
        }
        return playgroundService.addComment(commentRequest.getUid(),commentRequest.getTid(),
                commentRequest.getText(), commentRequest.getToken());
    }
}
