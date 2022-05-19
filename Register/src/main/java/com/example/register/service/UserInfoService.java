package com.example.register.service;

import com.example.register.entity.Result;
import com.example.register.entity.User;
import com.example.register.entity.UserInfo;
import com.example.register.repository.UserInfoRepository;
import com.example.register.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private UserRepository userRepository;
    public Result<List<UserInfo>> findUserInfoByUid(Integer uid){
        if(!userRepository.existsUserByUid(uid)){
            return new Result<>("用户不存在",201);
        }
        return new Result<>(userInfoRepository.findUserInfosByUid(uid));
    }
}
