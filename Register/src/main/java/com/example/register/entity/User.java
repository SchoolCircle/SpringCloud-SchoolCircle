/**
 *
 * @author KEPADEDAIDAI
 * @date 2022/3/10 15:49
 */
package com.example.register.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String pin;
    @JsonIgnore
    private String pin_time;
    private String email;
    private String token;
}
