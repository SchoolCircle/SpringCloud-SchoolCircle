package com.example.dao;

import com.example.entity.Tes;
import org.springframework.stereotype.Repository;

@Repository
public interface TesDao {
    public Tes getTesById(Integer id);
}
