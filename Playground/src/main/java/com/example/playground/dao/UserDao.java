package com.example.playground.dao;

import com.example.playground.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    public List<User> findByUid(Integer uid);
    public boolean existByUid(Integer uid);

    public List<String> getToken(Integer uid);
}
