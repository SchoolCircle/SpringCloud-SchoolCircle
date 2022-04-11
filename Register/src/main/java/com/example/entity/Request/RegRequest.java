package com.example.entity.Request;

import lombok.Data;

@Data
public class RegRequest {
    private String email;
    private String password;
    private String pin;
}
