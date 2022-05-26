package com.example.relationship.service;

import com.example.relationship.entity.Follow;
import com.example.relationship.entity.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FollowServiceTest {

    @Autowired
    private FollowService followService;
//    @Test
//    void findFollowedByUid() {
//    }
//
//    @Test
//    void findFollowingByUid() {
//    }

    @Test
    void addFollow() {
        Result<List<Follow>> result = followService.addFollow(2,3,"uid=3");
        System.out.println(result.toString());
        if(result.getCode()==200)
            System.out.println("关注成功");
        else System.out.println("关注失败");
    }

    @Test
    void delFollow() {
        Result<List<Follow>> result = followService.delFollow(2,3,"uid=3");
        if(result.getCode()==200){
            System.out.println("取关成功");
        }else{
            System.out.println("取关失败");
        }
    }
}