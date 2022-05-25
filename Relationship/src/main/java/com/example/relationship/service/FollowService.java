package com.example.relationship.service;

import com.example.relationship.entity.Follow;
import com.example.relationship.entity.Result;
import com.example.relationship.repository.FollowRepository;
import com.example.relationship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * 返回关注传入uid的人的列表
     * @param uid 被关注的uid
     * @return 关注信息
     */
    public Result<List<Follow>> findFollowedByUid(Integer uid){
        if(!userRepository.existsUserByUid(uid)){
            return new Result<>("用户不存在", 201);
        }
        return new Result<>(followRepository.findFollowsByFollowed(uid));
    }

    /**
     * 返回传入uid用户关注的用户的列表
     * @param uid 用户id
     * @return 关注信息
     */
    public Result<List<Follow>> findFollowingByUid(Integer uid){
        if(!userRepository.existsUserByUid(uid)){
            return new Result<>("用户不存在", 201);
        }
        return new Result<>(followRepository.findFollowsByFollowing(uid));
    }


}
