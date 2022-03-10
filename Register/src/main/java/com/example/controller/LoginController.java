/**
 *
 * @author KEPADEDAIDAI
 * @date 2022/3/10 16:05
 */
package com.example.controller;

import com.example.entity.Request.UserRequest;
import com.example.entity.Result;
import com.example.entity.User;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class LoginController {
    @Autowired private LoginService loginService;

    @PostMapping("/login")
    public Result<List<User>> login(@RequestBody UserRequest userRequest) {
        return loginService.login(userRequest.getEmail(),userRequest.getPass());
    }
}
