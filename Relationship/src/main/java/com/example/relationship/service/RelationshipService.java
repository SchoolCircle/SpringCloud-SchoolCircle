package com.example.relationship.service;

import com.example.relationship.entity.Relation;
import com.example.relationship.entity.Result;
import com.example.relationship.repository.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RelationshipService {

    @Autowired
    private RelationRepository relationRepository;

    public Result<List<Relation>> findByUid(Integer uid, String token){
        //TODO 完成token验证

        //TODO 完成uid存在性验证

        return new Result<>(relationRepository.findRelationsByUid1AndAndIsAlive(uid, 1));
    }

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



}
