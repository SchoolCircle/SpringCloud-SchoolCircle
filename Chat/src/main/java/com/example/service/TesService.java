package com.example.service;

import com.example.dao.TesDao;
import com.example.entity.Tes;
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
