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
public class Comment {

    private Integer cid;
    private Integer uid;
    private Integer tid;
    private String text;
    private String time;
    @JsonIgnore
    private boolean is_alive;

}