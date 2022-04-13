package com.example.controller;

import com.example.entity.Request.EmailRequest;
import com.example.entity.Result;
import com.example.entity.User;
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
    @PostMapping("/sendEmail")
    public Result<List<User>> sendEmail(@RequestBody EmailRequest emailRequest)
    {
        String email = emailRequest.getEmail();
        System.out.println(email);
        return regService.sendEmail(email);
    }
}
