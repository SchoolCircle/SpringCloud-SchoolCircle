package com.example.entity.request;

import lombok.Data;

@Data
public class UserRequest {
    private String uid;
    private String uname;
    private String pass;
    private String repass;  //验证码
    private String email;
    private String phone;
    private String sex;//性别
    private String birthday;
    private String qq;
    private String wechat;
}
