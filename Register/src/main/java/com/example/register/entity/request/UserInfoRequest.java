package com.example.register.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserInfoRequest {
    private Integer uid;

    private String token;

    private String email;

    private String uname;

    private String phone;

    private String qq;

    private String wechat;

    private String sex;

    private String college;

    private String img;
}
