package com.example.chat.entity.request;

import lombok.Data;

@Data
public class ChatRequest {
    private Integer uid1;
    private Integer uid2;
    private String token;
    private String text;
}
