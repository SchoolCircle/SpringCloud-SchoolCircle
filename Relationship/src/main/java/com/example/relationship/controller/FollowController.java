package com.example.relationship.controller;

import com.example.relationship.entity.Follow;
import com.example.relationship.entity.Result;
import com.example.relationship.entity.request.FollowAndTokenRequest;
import com.example.relationship.entity.request.UidAndTokenRequest;
import com.example.relationship.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FollowController {

    @Autowired
    private FollowService followService;

    //返回被关注列表
    @PostMapping("/findFollowedByUid")
    public Result<List<Follow>> findFollowedByUid(@RequestBody UidAndTokenRequest request) {
        if (request.getUid() == null || request.getToken() == null) return new Result<>("传入参数不足", 201);
        return followService.findFollowedByUid(request.getUid());
    }

    //返回关注列表
    @PostMapping("/findFollowingByUid")
    public Result<List<Follow>> findFollowingByUid(@RequestBody UidAndTokenRequest request) {
        if (request.getUid() == null || request.getToken() == null) return new Result<>("传入参数不足", 201);
        return followService.findFollowingByUid(request.getUid());
    }

    //添加关注
    @PostMapping("/addFollow")
    public Result<List<Follow>> addFollow(@RequestBody FollowAndTokenRequest request){
        if(request.getFollowed()==null||request.getFollowing()==null||request.getToken()==null){
            return new Result<>("传入参数不足", 201);
        }
        return followService.addFollow(request.getFollowed(), request.getFollowing(), request.getToken());
    }

    //取消关注
    @PostMapping("/delFollow")
    public Result<List<Follow>> delFollow(@RequestBody FollowAndTokenRequest request){
        if(request.getFollowed()==null||request.getFollowing()==null||request.getToken()==null){
            return new Result<>("传入参数不足", 201);
        }
        return followService.delFollow(request.getFollowed(), request.getFollowing(), request.getToken());
    }


}
