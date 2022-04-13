package com.example.entity.Request;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
