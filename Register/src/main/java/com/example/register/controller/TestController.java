package com.example.register.controller;

import com.example.register.entity.Result;
import com.example.register.entity.Test;
import com.example.register.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired private TestService testService;
    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }
    @GetMapping("/findAll")
    public Result<List<Test>> findAll()
    {
        return new Result<>(testService.findAll());
    }
}
