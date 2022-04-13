package com.example.service;

import com.example.entity.Result;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.utils.Sdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RegService {
    @Autowired
    private UserRepository userRepository;

    private User SaveUser(User user) {
        return userRepository.save(user);
    }
    /**
     * 发生注册或者重置密码的验证码
     */
    public Result<List<User>> sendEmail(String email) {
        User user;
        boolean isUserHad;
        if (userRepository.existsUserByEmail(email)){//该用户已经存在
            user = userRepository.findUserByEmail(email);
            isUserHad = true;
        } else {//用户还未存在，给予一个默认用户
            user = new User();
            user.setEmail(email);
            isUserHad = false;
        }
        //待修改,发验证码
        user.setPin("123456");
        Date now = new Date();
        user.setPin_time(Sdf.sdf.format(new Date(now.getTime()+ 600000)));
        List<User> list = new ArrayList<>();
        list.add(SaveUser(user));

//        if(!isUserHad)
//        {
//            //待补充，创建一条用户信息的记录
//        }

        return new Result<>(list);
    }
}
