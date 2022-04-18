package com.example.register.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserInfo {
    @Id
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "uname", nullable = false)
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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}