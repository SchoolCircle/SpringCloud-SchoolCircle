package com.example.relationship.service;

import com.example.relationship.entity.Follow;
import com.example.relationship.entity.Result;
import com.example.relationship.entity.User;
import com.example.relationship.repository.FollowRepository;
import com.example.relationship.repository.UserRepository;
import com.example.relationship.utils.Sdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserRepository userRepository;

    //检查token
    private boolean checkToken(String token, Integer uid){
        List<User> list = userRepository.findUsersByUid(uid);
        if(list.isEmpty()) return false;

        return list.get(0).getToken().equals(token); //token 匹配否？
    }
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

    /**
     *
     * @param followed 关注者
     * @param following 被关注者
     * @param token 关注者的token
     * @return 关注情况
     */
    public Result<List<Follow>> addFollow(Integer followed, Integer following, String token){
        if(!userRepository.existsUserByUid(followed)||!userRepository.existsUserByUid(following)){
            return new Result<>("用户不存在", 201);
        }
        if(!checkToken(token, following)){
            return new Result<>("无权操作", 201);
        }//关注操作是由following执行的，检查其权限
        if(followRepository.existsFollowsByFollowedAndAndFollowing(followed,following)){
            return new Result<>("已关注",201);
        }
        Follow follow = new Follow();
        follow.setFollowed(followed);
        follow.setFollowing(following);
        follow.setFollowTime(Sdf.sdf.format(new Date()));//当前时间
        follow = followRepository.save(follow);
        return new Result<>(Collections.singletonList(follow));
    }

    /**
     *
     * @param followed 被关注者
     * @param following 关注者
     * @param token 关注者token
     * @return 是否成功， 200为成功, 201不成功
     */
    public Result<List<Follow>> delFollow(Integer followed, Integer following, String token){
        if(!userRepository.existsUserByUid(followed)||!userRepository.existsUserByUid(following)){
            return new Result<>("用户不存在", 201);
        }
        if(!checkToken(token, following)){
            return new Result<>("无权操作", 201);
        }//取关操作是由following执行的，检查其权限
        List<Follow> list = followRepository.findFollowsByFollowedAndFollowing(followed,following);
        if(list.isEmpty()){
            return new Result<>("未关注", 201);
        }
        Follow follow = list.get(0);
        followRepository.delete(follow);
        return new Result<>("success", 200);
    }

}
