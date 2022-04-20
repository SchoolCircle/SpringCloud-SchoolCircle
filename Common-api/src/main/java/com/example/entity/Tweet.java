package com.example.entity;

import javax.persistence.*;
import java.time.Instant;


@Table(name = "tweet")
@Entity
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid", nullable = false)
    private Integer id;

    @Column(name = "uid", nullable = false)
    private Integer uid;

    @Column(name = "time", nullable = false)
    private Instant time;

    @Column(name = "type", nullable = false)
    private Integer type;

    @Lob
    @Column(name = "text")
    private String text;

    @Column(name = "is_alive", nullable = false)
    private Integer isAlive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Integer isAlive) {
        this.isAlive = isAlive;
    }

}