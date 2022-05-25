package com.example.relationship.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UidAndTokenRequest {

    private Integer uid;
    private String token;//虽然好像用不到，但是先传进来吧
}
