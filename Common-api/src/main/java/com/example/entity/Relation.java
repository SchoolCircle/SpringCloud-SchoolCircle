package com.example.entity;

import javax.persistence.*;


@Table(name = "relation")
@Entity
public class Relation {
    @Id
    @Column(name = "uid1", nullable = false)
    private Integer uid1;

    @Column(name = "uid2", nullable = false)
    private Integer uid2;

    @Column(name = "is_alive", nullable = false)
    private Integer isAlive;


}