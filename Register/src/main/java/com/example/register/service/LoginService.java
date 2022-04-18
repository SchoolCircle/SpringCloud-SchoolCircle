package com.example.register.service;

import com.example.register.entity.Result;
import com.example.register.entity.User;
import com.example.register.repository.UserRepository;
import com.example.register.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;
    public Result<List<User>> login(String email, String password){
        if(!userRepository.existsUserByEmail(email)){
            return new Result<>("用户不存在", 201);
        }
        User user = userRepository.findUserByEmail(email);
        if(!user.getPassword().equals(Md5.md5(password, email))){
            return new Result<>("密码错误", 201);
        }
        return new Result<>(Collections.singletonList(user));
    }
}
