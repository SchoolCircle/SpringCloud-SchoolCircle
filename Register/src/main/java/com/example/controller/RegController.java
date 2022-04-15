package com.example.controller;

import com.example.entity.request.EmailRequest;
import com.example.entity.request.LoginRequest;
import com.example.entity.request.RegRequest;
import com.example.entity.Result;
import com.example.entity.User;
import com.example.service.LoginService;
import com.example.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegController {

    @Autowired
    private RegService regService;

    @Autowired
    private LoginService loginService;

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
        if (email.isEmpty() || password.isEmpty()) {
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
}
