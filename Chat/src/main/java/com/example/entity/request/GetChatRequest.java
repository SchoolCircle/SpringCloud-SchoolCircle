package com.example.entity.request;

import lombok.Data;

@Data
public class GetChatRequest {
    private Integer uid1;
    private Integer uid2;
    private String token;
    private Integer pageSize;
    private Integer pageNum;
}
