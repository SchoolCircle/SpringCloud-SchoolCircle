package com.example.entity.request;

import lombok.Data;

@Data
public class RegRequest {
    private String email;
    private String password;
    private String pin;
}
