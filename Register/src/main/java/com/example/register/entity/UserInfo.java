package com.example.register.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserInfo {
    @Id
    @Column(name = "uid")
    private Integer uid;

    @Column(name = "email")
    private String email;

    @Column(name = "uname")
    private String uname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "qq")
    private String qq;

    @Column(name = "wechat")
    private String wechat;

    @Column(name = "sex")
    private String sex;

    @Column(name = "college")
    private String college;

}