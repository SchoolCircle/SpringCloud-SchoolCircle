package com.example.controller;

import com.example.entity.request.TesRequest;
import com.example.entity.Result;
import com.example.entity.Tes;
import com.example.service.TesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TesController {
    @Autowired
    private TesService tesService;

    @GetMapping("/tes/hello")
    public String hello(){
        return "hello";
    }
    @PostMapping("/tes/findById")
    public Result<List<Tes>> findById(@RequestBody TesRequest tesRequest)
    {
        Tes tes = tesService.findTesById(tesRequest.getId());
        List<Tes> list = new ArrayList<>();
        list.add(tes);
        return new Result<>(list);
    }
}
