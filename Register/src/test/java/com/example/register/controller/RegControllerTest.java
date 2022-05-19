package com.example.register.controller;

import com.example.register.service.LoginService;
import com.example.register.service.RegService;
import com.example.register.service.TestService;
import com.example.register.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RegControllerTest {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegService regService;

//    @Autowired
//    private TestService testService;
    @Autowired
    private UserInfoService userInfoService;

    @Test
    void sendEmail() {
    }

    @Test
    void reg() {
    }

    @Test
    void login() {
    }

    @Test
    void resetPassword() {
    }

    @Test
    void findUserInfoByUid() {

    }
}