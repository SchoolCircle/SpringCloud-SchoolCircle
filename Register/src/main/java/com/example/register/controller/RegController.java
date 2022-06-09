package com.example.register.controller;

import com.example.register.entity.Pic;
import com.example.register.entity.UserInfo;
import com.example.register.entity.request.*;
import com.example.register.entity.Result;
import com.example.register.entity.User;
import com.example.register.service.LoginService;
import com.example.register.service.RegService;
import com.example.register.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
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

    @PostMapping("/findUserInfoByUid")
    public Result<List<UserInfo>> findUserInfoByUid(@RequestBody UidAndTokenRequest request){
        if(request.getUid()==null)
        {
            return new Result<>("传入参数有误",201);
        }
        return userInfoService.findUserInfoByUid(request.getUid());
    }

    @PostMapping("/resetUserInfo")
    public Result<List<UserInfo>> resetUserInfo(@RequestBody UserInfoRequest request){
        return userInfoService.resetUserInfo(request);
    }
    @PostMapping("/upload")
    public Result<List<Pic>> upload(@RequestParam(value = "file") MultipartFile file){

//        if(request.getToken()==null||request.getUid()==null) {
//            return new Result<>("传入参数不足", 201);
//        }
//        if(!regService.checkToken(request.getToken(), request.getUid())){
//            return new Result<>("无权上传",201);
//        }
        if (file.isEmpty()) {

            return new Result<>("文件为空", 201);
        }
        String filePath = "d:/file/pic/";
        String name = "pic" + new Date().getTime() + Math.random() +".jpg";
        File dest = new File(filePath + name);
        try {
            System.out.println("ok");
            file.transferTo(dest);
//             LOGGER.info("上传成功");
            Pic pic = new Pic(name);
            return new Result<>(Collections.singletonList(pic));
        } catch (IOException e) {
            // LOGGER.error(e.toString(), e);
        }
        return new Result<>("fail", 201);
    }
}
