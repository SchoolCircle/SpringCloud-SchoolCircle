package com.example.chat.dao;

import com.example.chat.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
    public List<User> findByUid(Integer uid);
    public boolean existByUid(Integer uid);
}
