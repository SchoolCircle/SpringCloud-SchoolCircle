package com.example.playground.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TweetRequest {
    private Integer uid;
    private String token;
    private String text;
    private String title;
    private Integer haveImg;
    private String img;
}
