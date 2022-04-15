package com.example.controller;

import com.example.entity.Chat;
import com.example.entity.Result;
import com.example.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private ChatService chatService;

    @GetMapping("findAllChat")
    public Result<List<Chat>>findAllChat(){
        return chatService.findAllChat();
    }
}
