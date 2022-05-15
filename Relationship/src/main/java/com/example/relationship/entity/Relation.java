package com.example.relationship.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "relation")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Relation {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)//自动递增
    private Integer rid;
    @Column(name = "uid1")
    private Integer uid1;

    @Column(name = "uid2")
    private Integer uid2;

    @Column(name = "is_alive")
    private boolean isAlive;


}