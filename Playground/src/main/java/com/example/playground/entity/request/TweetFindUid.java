package com.example.playground.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TweetFindUid {
    private Integer uid;
    private Integer PageNum;
    private Integer PageSize;//分页查询预留
}
