package com.example.service;

import com.example.entity.Tes;
import com.example.repository.TesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TesService {
    @Autowired
    private TesRepository tesRepository;

    public List<Tes> findAll(){
        return tesRepository.findAll();
    }
}
