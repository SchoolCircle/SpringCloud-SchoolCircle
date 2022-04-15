package com.example.service;

import com.example.dao.ChatDao;
import com.example.entity.Chat;
import com.example.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    @Autowired
    private ChatDao chatDao;

    public Result<List<Chat>> findAllChat()
    {
        return new Result<>(chatDao.findAllChat());
    }
}
