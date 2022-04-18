package com.example.chat.service;

import com.example.chat.dao.TesDao;
import com.example.chat.entity.Tes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TesService {
    @Autowired
    private TesDao tesDao;

    public Tes findTesById(Integer id){
        return tesDao.getTesById(id);
    }
}
