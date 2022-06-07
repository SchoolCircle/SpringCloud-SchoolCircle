package com.example.playground.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Tweet {
    private Integer tid;
    private Integer uid;
    private String time;
    private Integer type;//类型暂无作用
    private String text;
//    @JsonIgnore
    private boolean is_alive; //是否被删除
    private String title;//标题
    private Integer have_img;
    private String img;
}