package com.example.relationship.controller;

import com.example.relationship.entity.Relation;
import com.example.relationship.entity.Result;
import com.example.relationship.entity.request.AddRelationRequest;
import com.example.relationship.entity.request.FindRelationRequest;
import com.example.relationship.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private RelationshipService relationshipService;

    @GetMapping("/hello")
    public String hello()
    {
        return "hello,this is Relationship 8006";
    }

    @PostMapping("/findByUid")
    public Result<List<Relation>> findByUid(@RequestBody FindRelationRequest findRelationRequest){
        if(findRelationRequest.getUid()==null||findRelationRequest.getToken()==null){
            return new Result<>("传入参数不足",201);
        }
        return relationshipService.findByUid(findRelationRequest.getUid(),
                findRelationRequest.getToken());

    }

    @PostMapping("/addRelation")
    public Result<List<Relation>> addRelation(@RequestBody AddRelationRequest addRelationRequest){
        if(addRelationRequest.getUid1()==null||addRelationRequest.getUid2()==null
                || addRelationRequest.getToken()==null){
            return new Result<>("传入参数不足",201);
        }
        return relationshipService.addRelation(addRelationRequest.getUid1(),
                addRelationRequest.getUid2(), addRelationRequest.getToken());
    }

}
