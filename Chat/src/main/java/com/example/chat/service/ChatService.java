package com.example.chat.service;

import com.example.chat.dao.ChatDao;
import com.example.chat.dao.UserDao;
import com.example.chat.entity.Chat;
import com.example.chat.entity.Result;
import com.example.chat.entity.User;
import com.example.chat.entity.query.ChatQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    @Autowired
    private ChatDao chatDao;
    @Autowired
    private UserDao userDao;
    public Result<List<Chat>> findAllChat()
    {
        return new Result<>(chatDao.findAllChat());
    }

    public Result<List<Chat>> findByUid(Integer uid1, Integer uid2,String token){
        if(uid1==null||uid2==null||token==null)
        {
            return new Result<>("传入参数不足",201);
        }
        List<User> list = userDao.findByUid(uid1);
        if(list.isEmpty()) return new Result<>("用户不存在", 201);
        if(!list.get(0).getToken().equals(token)){
            return new Result<>("无权查看该用户记录",201);
        }
        //TODO 待修改，应该是两个人都有权限查看，这里只实现了一个人有权限
        ChatQuery chatQuery = new ChatQuery();
        chatQuery.setUid_from(uid1);
        chatQuery.setUid_to(uid2);


        return new Result<>(chatDao.findByUid2(chatQuery));
    }
}
