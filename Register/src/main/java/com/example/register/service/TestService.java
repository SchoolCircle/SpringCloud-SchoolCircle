package com.example.register.service;

import com.example.register.entity.Test;
import com.example.register.repository.TestRepository;
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
