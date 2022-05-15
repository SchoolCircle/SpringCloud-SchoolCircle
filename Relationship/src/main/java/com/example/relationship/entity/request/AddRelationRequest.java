package com.example.relationship.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class AddRelationRequest {
    private Integer uid1;
    private Integer uid2;
    private String token;
}

