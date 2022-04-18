package com.example.chat.controller;

import com.example.chat.entity.Chat;
import com.example.chat.entity.Result;
import com.example.chat.entity.request.GetChatRequest;
import com.example.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private ChatService chatService;

    @GetMapping("/findAllChat")
    public Result<List<Chat>>findAllChat(){
        return chatService.findAllChat();
    }
    @PostMapping("/getChat")
    public Result<List<Chat>> getChat(@RequestBody GetChatRequest getChatRequest)
    {
        return chatService.findByUid(getChatRequest.getUid1(), getChatRequest.getUid2());
    }
}
