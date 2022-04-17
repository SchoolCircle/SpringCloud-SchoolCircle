package com.example.service;

import com.example.dao.ChatDao;
import com.example.entity.Chat;
import com.example.entity.Result;
import com.example.entity.query.ChatQuery;
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

    public Result<List<Chat>> findByUid(Integer uid1, Integer uid2){
        ChatQuery chatQuery = new ChatQuery();
        chatQuery.setUid_from(uid1);
        chatQuery.setUid_to(uid2);
        System.out.println(uid1);
        System.out.println(uid2);
        return new Result<>(chatDao.findByUid2(chatQuery));
    }
}
