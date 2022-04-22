package com.example.playground.controller;

import com.example.playground.entity.Result;
import com.example.playground.entity.Tweet;
import com.example.playground.service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private PlaygroundService playgroundService;


    @GetMapping("/findAll")
    public Result<List<Tweet>> findAll()
    {
        return playgroundService.findAll();
    }
}
