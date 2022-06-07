package com.example.playground.controller;

import com.example.playground.entity.Comment;
import com.example.playground.entity.Pic;
import com.example.playground.entity.Result;
import com.example.playground.entity.Tweet;
import com.example.playground.entity.request.*;
import com.example.playground.service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private PlaygroundService playgroundService;


    @GetMapping("/findAll")//TODO 测试用，最终删除该接口
    public Result<List<Tweet>> findAll() {
        return playgroundService.findAll();
    }

    @PostMapping("/addTweet")
    public Result<List<Tweet>> addTweet(@RequestBody TweetRequest tweetRequest) {
        if (tweetRequest.getText() == null || tweetRequest.getToken() == null ||
                tweetRequest.getUid() == null|| tweetRequest.getTitle()==null) {
            return new Result<>("传入参数不足", 201);
        }
//        System.out.println("uid ="+tweetRequest.getUid().toString() + " token="+tweetRequest.getToken()+" text="+tweetRequest.getText());
        return playgroundService.addTweet(tweetRequest.getUid(), tweetRequest.getText(),
                tweetRequest.getToken(), tweetRequest.getTitle());
    }

    @PostMapping("/addComment")
    public Result<List<Comment>> addComment(@RequestBody CommentRequest commentRequest) {
        if (commentRequest.getText() == null || commentRequest.getTid() == null
                || commentRequest.getToken() == null || commentRequest.toString() == null) {
            return new Result<>("传入参数不足", 201);
        }
        return playgroundService.addComment(commentRequest.getUid(),commentRequest.getTid(),
                commentRequest.getText(), commentRequest.getToken());
    }

    @PostMapping("/findTweetByUid")
    public Result<List<Tweet>> findTweetByUid(@RequestBody TweetFindUid tweetFindUid)
    {
        if(tweetFindUid.getUid()==null) return new Result<>("传入参数不足", 201);
        return playgroundService.findTweetByUid(tweetFindUid.getUid());
    }

    @PostMapping("/findMyTweet")
    public Result<List<Tweet>> findMyTweet(@RequestBody TweetFindMyself tweetFindMyself){
        if(tweetFindMyself.getToken()==null||tweetFindMyself.getUid()==null)
            return new Result<>("传入参数不足",201);
        System.out.println("token="+tweetFindMyself.getToken()+"||");
        return playgroundService.findMyTweet(tweetFindMyself.getUid(), tweetFindMyself.getToken());
    }
    @PostMapping ("/findCommentByTid")
    public Result<List<Comment>> findCommentByTid(@RequestBody TidAndUidRequest request){
        if(request.getTid()==null)
            return new Result<>("传入参数不足",201);
        return playgroundService.findCommentsByTid(request.getTid());
    }

    @PostMapping("/findCommentByUid")
    public Result<List<Comment>> findCommentByUid(@RequestBody TidAndUidRequest request){
        if(request.getUid()==null)
            return new Result<>("传入参数不足",201);
        return playgroundService.findCommentsByUid(request.getUid());
    }
    @PostMapping("/upload")
    public Result<List<Pic>> upload(@RequestParam(value = "file") MultipartFile file) {

//        if(request.getToken()==null||request.getUid()==null) {
//            return new Result<>("传入参数不足", 201);
//        }
//        if(!regService.checkToken(request.getToken(), request.getUid())){
//            return new Result<>("无权上传",201);
//        }
        if (file.isEmpty()) {

            return new Result<>("文件为空", 201);
        }
        String filePath = "d:/file/pic2/";
        String name = "pic" + new Date().getTime() + Math.random() + ".jpg";
        File dest = new File(filePath + name);
        try {
            System.out.println("ok");
            file.transferTo(dest);
//             LOGGER.info("上传成功");
            Pic pic = new Pic(name);
            return new Result<>(Collections.singletonList(pic));
        } catch (IOException e) {
            // LOGGER.error(e.toString(), e);
        }
        return new Result<>("fail", 201);
    }
}
