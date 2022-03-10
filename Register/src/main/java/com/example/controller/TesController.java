package com.example.controller;

import com.example.entity.Result;
import com.example.entity.Tes;
import com.example.service.TesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TesController {

    @Autowired
    private TesService tesService;

    @GetMapping("/findAll")
    public Result<List<Tes>> findAll(){
        return new Result<>(tesService.findAll());
    }
    @GetMapping("/hello")
    public String hello(){
        return "Hello!,This is Tes";
    }
}
