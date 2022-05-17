package com.example.relationship.repository;

import com.example.relationship.entity.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelationRepository extends JpaRepository<Relation, Integer> {

    List<Relation> findRelationsByUid1AndAndIsAlive(Integer uid1, Integer isAlive);

    /**
     * 判断两个用户是否是好友
     * @param uid1 用户1的id
     * @param uid2 用户2的id
     * @param isAlive 默认传入1
     * @return true如果两用户是好友，false如果两用户不是好友
     */
    boolean existsRelationByUid1AndUid2AndIsAlive(Integer uid1, Integer uid2, Integer isAlive);

}
