package com.example.register.service;

import com.example.register.entity.Result;
import com.example.register.entity.User;
import com.example.register.entity.UserInfo;
import com.example.register.entity.request.UserInfoRequest;
import com.example.register.repository.UserInfoRepository;
import com.example.register.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private UserRepository userRepository;

    public Result<List<UserInfo>> findUserInfoByUid(Integer uid) {
        if (!userRepository.existsUserByUid(uid)) {
            return new Result<>("用户不存在", 201);
        }
        return new Result<>(userInfoRepository.findUserInfosByUid(uid));
    }

    // 重置用户信息
    public Result<List<UserInfo>> resetUserInfo(UserInfoRequest request) {
        if (request.getUid() == null) return null;
        if (!userInfoRepository.existsById(request.getUid())) {
            return new Result<>("用户不存在", 201);
        }
        String need = userRepository.findUserByUid(request.getUid()).getToken();
        if(request.getToken()==null || !need.equals(request.getToken())){
            return new Result<>("无权操作", 201);
        }
        UserInfo userInfo = userInfoRepository.findUserInfosByUid(request.getUid()).get(0);
        if (request.getCollege() != null) {
            userInfo.setCollege(request.getCollege());
        }
        if (request.getImg() != null) {
            userInfo.setImg(request.getImg());
        }
        if(request.getPhone()!=null){
            userInfo.setPhone(request.getPhone());
        }
        if(request.getQq()!=null){
            userInfo.setQq(request.getQq());
        }
        if(request.getSex()!=null){
            userInfo.setSex(request.getSex());
        }
        if(request.getUname()!=null){
            userInfo.setUname(request.getUname());
        }
        if(request.getWechat()!=null){
            userInfo.setWechat(request.getWechat());
        }
        userInfoRepository.save(userInfo);
        return new Result<>(Collections.singletonList(userInfo));
    }
}
