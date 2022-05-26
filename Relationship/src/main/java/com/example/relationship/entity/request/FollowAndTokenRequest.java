package com.example.relationship.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FollowAndTokenRequest {//用于获得关注和取关时的post
    private Integer followed;//被关注者
    private Integer following;//关注者
    private String token;//关注者的token
}
