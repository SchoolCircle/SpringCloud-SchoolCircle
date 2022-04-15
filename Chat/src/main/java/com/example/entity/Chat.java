package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    private Integer chat_id;
    private Integer uid_from;
    private Integer uid_to;
    private String text;
    private String time;
}
