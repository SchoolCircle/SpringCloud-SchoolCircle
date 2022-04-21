package com.example.entity;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="user")
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
