package com.example.relationship.service;

import com.example.relationship.entity.FriendAsk;
import com.example.relationship.entity.Relation;
import com.example.relationship.entity.Result;
import com.example.relationship.entity.User;
import com.example.relationship.repository.FriendAskRepository;
import com.example.relationship.repository.RelationRepository;
import com.example.relationship.repository.UserRepository;
import com.example.relationship.utils.Sdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class RelationshipService {

    @Autowired
    private RelationRepository relationRepository;

    @Autowired
    private FriendAskRepository friendAskRepository;

    @Autowired
    private UserRepository userRepository;


    /**
     * 判断用户是否存在
     * @param uid 用户id
     * @return 存在返回true, 不存在返回false
     */
    private boolean checkUid(Integer uid){
        return userRepository.existsUserByUid(uid);
    }

    /**
     * 获得用户的token
     * @param uid 用户id
     * @return String token
     */
    private String getTokenByUid(Integer uid){
        List<User> list = userRepository.findUsersByUid(uid);
        if(list.isEmpty()) return "";
        return list.get(0).getToken();
    }

    /**
     * 查找按照本人的uid查找本人好友
     * @param uid id
     * @param token 权限
     * @return json 好友列表
     */
    public Result<List<Relation>> findByUid(Integer uid, String token){
        //TODO 完成token验证

        //TODO 完成uid存在性验证

        return new Result<>(relationRepository.findRelationsByUid1AndAndIsAlive(uid, 1));
    }

    /**
     * 添加好友接口
     * @param uid1 用户1的uid
     * @param uid2 用户2的uid
     * @param token 用户1的权限
     * @return Result 添加的记录或者错误信息
     */
    public Result<List<Relation>> addRelation(Integer uid1, Integer uid2, String token){//添加好友
        //TODO token权限验证

        //TODO 关系已存验证

        Relation relation = new Relation();
        relation.setIsAlive(1);
        relation.setUid1(uid1);
        relation.setUid2(uid2);
        relation = relationRepository.save(relation);
        return new Result<>(Collections.singletonList(relation));

    }


    /**
     * 发起添加好友请求
     * @param uidFrom 添加好友发起者
     * @param uidTo   添加好友目标
     * @param token   发起者权限
     * @return Result 记录结果
     */
    public Result<List<FriendAsk>> addFriendAsk(Integer uidFrom, Integer uidTo, String token){
        //如果两人已经是好友
        if(relationRepository.existsRelationByUid1AndUid2AndIsAlive(uidFrom,uidTo,1)){
            return new Result<>("已经是好友",201);
        }
        if(!checkUid(uidFrom)||!checkUid(uidTo)){//用户不存在
            return new Result<>("用户不存在",201);
        }
        String need = getTokenByUid(uidFrom);//获得请求的用户的token
        if(!Objects.equals(need, token)){
            return new Result<>("无权操作",201);
        }
        //TODO 相同请求是否存在查询
        FriendAsk friendAsk = new FriendAsk();
        friendAsk.setUidFrom(uidFrom);
        friendAsk.setUidTo(uidTo);
        friendAsk.setIsFail(0);
        friendAsk.setIsSuccess(0);
        friendAsk.setTime(Sdf.sdf.format(new Date()));
        friendAsk.setIsAlive(1);
        friendAsk = friendAskRepository.save(friendAsk);
        return new Result<>(Collections.singletonList(friendAsk));
    }

}
