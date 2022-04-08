package com.example.service;

import com.example.entity.Test;
import com.example.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;
    public List<Test> findAll()
    {
        return testRepository.findAll();
    }
}
