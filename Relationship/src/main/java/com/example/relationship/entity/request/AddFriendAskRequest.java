package com.example.relationship.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AddFriendAskRequest {
    private Integer uid1;
    private String token;
    private Integer uid2;

}
