package com.example.playground.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CommentRequest {
    private Integer tid;
    private Integer uid;
    private String token;
    private String text;
}
