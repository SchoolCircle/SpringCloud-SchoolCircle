package com.example.entity;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "ccomment")
@Entity
public class Ccomment {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "ccid", nullable = false)
    private Integer id;

    @Column(name = "cid", nullable = false)
    private Integer cid;

    @Column(name = "uid", nullable = false)
    private Integer uid;

    @Column(name = "time", nullable = false)
    private Instant time;

    @Lob
    @Column(name = "text")
    private String text;

    @Column(name = "tid")
    private Integer tid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

}