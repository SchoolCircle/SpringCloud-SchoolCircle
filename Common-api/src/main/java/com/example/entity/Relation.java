package com.example.entity;

import javax.persistence.*;


@Table(name = "relation")
@Entity
public class Relation {
    @Id
    @Column(name = "uid1", nullable = false)
    private Integer id;

    @Column(name = "uid2", nullable = false)
    private Integer uid2;

    @Column(name = "is_alive", nullable = false)
    private Integer isAlive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid2() {
        return uid2;
    }

    public void setUid2(Integer uid2) {
        this.uid2 = uid2;
    }

    public Integer getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Integer isAlive) {
        this.isAlive = isAlive;
    }

}