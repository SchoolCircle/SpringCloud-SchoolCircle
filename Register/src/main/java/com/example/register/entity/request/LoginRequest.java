package com.example.register.entity.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
