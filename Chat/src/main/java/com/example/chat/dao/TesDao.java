package com.example.chat.dao;

import com.example.chat.entity.Tes;
import org.springframework.stereotype.Repository;

@Repository
public interface TesDao {
    public Tes getTesById(Integer id);
}
