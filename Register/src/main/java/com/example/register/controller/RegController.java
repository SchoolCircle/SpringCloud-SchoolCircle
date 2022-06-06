package com.example.register.controller;

import com.example.register.entity.UserInfo;
import com.example.register.entity.request.EmailRequest;
import com.example.register.entity.request.LoginRequest;
import com.example.register.entity.request.RegRequest;
import com.example.register.entity.Result;
import com.example.register.entity.User;
import com.example.register.entity.request.UserInfoRequest;
import com.example.register.service.LoginService;
import com.example.register.service.RegService;
import com.example.register.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegController {

    @Autowired
    private RegService regService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/sendEmail")
    public Result<List<User>> sendEmail(@RequestBody EmailRequest emailRequest) {
        String email = emailRequest.getEmail();
        System.out.println(email);
        return regService.sendEmail(email);
    }

    @PostMapping("/reg")
    public Result<List<User>> reg(@RequestBody RegRequest regRequest) {
        String email = regRequest.getEmail();
        String password = regRequest.getPassword();
        String pin = regRequest.getPin();
        if (email == null || password == null || pin == null)
            return new Result<>("传入参数不足", 201);
        return regService.reg(email, password, pin);
    }

    @PostMapping("/login")
    public Result<List<User>> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        if (email==null || password==null||email.equals("")||password.equals("")) {
            return new Result<>("传入参数不足", 201);
        }
        return loginService.login(email,password);
    }

    @PostMapping("/resetPassword")
    public Result<List<User>> resetPassword(@RequestBody RegRequest regRequest) {
        String email = regRequest.getEmail();
        String password = regRequest.getPassword();
        String pin = regRequest.getPin();
        if (email == null || password == null || pin == null)
            return new Result<>("传入参数不足", 201);
        return regService.reg(email, password, pin);
    }
//    @GetMapping("/sendMailTest")
//    public String sendMail(){
////        regService.sendTxtMail();
//        return "success";
//    }

    @GetMapping("/findUserInfoByUid/{uid}")
    public Result<List<UserInfo>> findUserInfoByUid(@PathVariable("uid") Integer uid){
        if(uid==null)
        {
            return new Result<>("传入参数有误",201);
        }
        return userInfoService.findUserInfoByUid(uid);
    }

    @PostMapping("/resetUserInfo")
    public Result<List<UserInfo>> resetUserInfo(@RequestBody UserInfoRequest request){
        return userInfoService.resetUserInfo(request);
    }
}
