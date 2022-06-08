package com.example.playground.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Favourite {
    private Integer fid;
    private Integer tid;
    private Integer uid;
    private String time;
    private Integer is_alive;
}
