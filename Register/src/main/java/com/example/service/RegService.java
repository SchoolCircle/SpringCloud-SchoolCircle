package com.example.service;

import com.example.entity.Result;
import com.example.entity.User;
import com.example.entity.UserInfo;
import com.example.repository.UserInfoRepository;
import com.example.repository.UserRepository;
import com.example.utils.Md5;
import com.example.utils.Sdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class RegService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;


    private User SaveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * 保存用户信息
     *
     * @return UserInfo
     */
    private UserInfo SaveUserInfo(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }


    /**
     * 发生注册或者重置密码的验证码
     */
    public Result<List<User>> sendEmail(String email) {
        User user;
        boolean isUserHad;
        if (userRepository.existsUserByEmail(email)) {//该用户已经存在
            user = userRepository.findUserByEmail(email);
            isUserHad = true;
        } else {//用户还未存在，给予一个默认用户
            user = new User();
            user.setEmail(email);
            //TODO 此处待修改token生成机制
            user.setToken("123");
            isUserHad = false;
        }
        //待修改,发验证码
        user.setPin("123456");
        Date now = new Date();
        user.setPin_time(Sdf.sdf.format(new Date(now.getTime() + 600000)));
        SaveUser(user);

        if (!isUserHad) {
            UserInfo userInfo = new UserInfo();
            userInfo.setEmail(email);
            userInfo.setId(user.getUid());
            int code = (int) ((Math.random() * 9 + 1) * 1000000);
            userInfo.setUname("游客" + code);
            SaveUserInfo(userInfo);
        }
        return new Result<>("success", 200);
    }

    public Result<List<User>> Reg(String email, String password, String pin) {
        if (!userRepository.existsUserByEmail(email))
            return new Result<>("邮箱不存在", 201);
        User user = userRepository.findUserByEmail(email);
        try {
            Date tagDate = Sdf.sdf.parse(user.getPin_time());//有效期
            if (tagDate.before(new Date())) {//有效期在当前时间之前
                return new Result<>("验证码已过期", 201);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (!Objects.equals(pin, user.getPin())) {
            return new Result<>("验证码错误", 201);
        }
        user.setPassword(Md5.md5(password,email));
        List<User> list = new ArrayList<>();
        list.add(SaveUser(user));
        return new Result<>(list);
    }
}
