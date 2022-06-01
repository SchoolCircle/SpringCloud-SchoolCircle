package com.example.playground.service;

import com.example.playground.dao.CommentDao;
import com.example.playground.dao.TweetDao;
import com.example.playground.dao.UserDao;
import com.example.playground.entity.Comment;
import com.example.playground.entity.Result;
import com.example.playground.entity.Tweet;
import com.example.playground.utils.Sdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class PlaygroundService {
    @Autowired
    private TweetDao tweetDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserDao userDao;


    public Result<List<Tweet>> findAll() {
        return new Result<>(tweetDao.findAll());
    }

    public Result<List<Tweet>> addTweet(Integer uid, String text, String token,String title) {
        if (!userDao.existByUid(uid)) {
            return new Result<>("用户不存在", 201);
        }
        String need = userDao.getToken(uid).get(0);
        if (!need.equals(token)) {
            return new Result<>("无权发布信息", 201);
        }
        Tweet tweet = new Tweet();
        tweet.setUid(uid);
        tweet.setText(text);
        tweet.setType(1); //TODO 传参时添加类型
        tweet.setTime(Sdf.sdf.format(new Date()));
        tweet.setTitle(title);
        int ans = tweetDao.addTweet(tweet);
        if (ans == 0) return new Result<>("添加失败", 201);
        tweet.setTid(ans);
        return new Result<>(Collections.singletonList(tweet));
    }

    public Result<List<Comment>> addComment(Integer uid, Integer tid, String text, String token) {
        if (!userDao.existByUid(uid)) {
            return new Result<>("用户不存在", 201);
        }
        String need = userDao.getToken(uid).get(0);
        if (!need.equals(token)) {
            return new Result<>("无权发布信息", 201);
        }
        if (!tweetDao.existByTid(tid)) {
            return new Result<>("帖子不存在", 201);
        }
        Comment comment = new Comment();
//        comment.set_alive(true);//前端不显示该值，所以不需要处理
        comment.setText(text);
        comment.setTid(tid);//评论发布在什么帖子下面
        comment.setUid(uid);//发帖用户
        comment.setTime(Sdf.sdf.format(new Date()));//当前时间设定为
        int ans = commentDao.addComment(comment);
        if (ans == 0) {
            return new Result<>("添加失败", 201);
        }
        return new Result<>(Collections.singletonList(comment));
    }

    //查看别人的发帖
    public Result<List<Tweet>> findTweetByUid(Integer uid) {
        if (!userDao.existByUid(uid)) {
            return new Result<>("用户不存在", 201);
        }
        return new Result<>(tweetDao.findAliveTweetByUid(uid));
    }

    //查看自己发帖
    public Result<List<Tweet>> findMyTweet(Integer uid, String token) {
        if (!userDao.existByUid(uid)) {//用户查询
            return new Result<>("用户不存在", 201);
        }
        try {//权限验证
            String need = userDao.findByUid(uid).get(0).getToken();
            if (!token.equals(need)) {
                return new Result<>("无权访问", 201);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("下标越界，没有找到用户");
            return new Result<>("用户不存在", 201);
        }
        return new Result<>(tweetDao.findAllTweetByUid(uid));
    }

}
