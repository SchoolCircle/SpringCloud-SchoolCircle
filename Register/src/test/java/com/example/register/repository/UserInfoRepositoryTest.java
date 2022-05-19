package com.example.register.repository;

import com.example.register.entity.User;
import com.example.register.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserInfoRepositoryTest {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    void findUserInfosByUid() {
        List<UserInfo> list = userInfoRepository.findUserInfosByUid(2);
        for(UserInfo x:list)
            System.out.println(x);
    }

    @Test
    void findUserInfosByEmail() {
        List<UserInfo> list = userInfoRepository.findUserInfosByEmail("166974372@qq.com");
        for(UserInfo x:list)
            System.out.println(x);
    }


}