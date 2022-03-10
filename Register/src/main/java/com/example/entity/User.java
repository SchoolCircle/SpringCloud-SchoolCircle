package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String name;
    @JsonIgnore
    private String pass;
    @JsonIgnore
    private String repass;  //验证码
    @JsonIgnore
    private String repasstime;  //验证码有效期
    private String email;
    private String phone;
    private String sex;//性别
    private String birthday;
    private String qq;
    private String wechat;
}
