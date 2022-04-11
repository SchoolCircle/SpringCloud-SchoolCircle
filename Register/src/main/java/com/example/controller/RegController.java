package com.example.controller;

import com.example.entity.Request.EmailRequest;
import com.example.entity.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegController {

    @PostMapping("/sendEmail")
    public Result<String> sendEmail(@RequestBody EmailRequest emailRequest)
    {
        String email = emailRequest.getEmail();

        return new Result<>("收到"+email, 200);
    }
}
