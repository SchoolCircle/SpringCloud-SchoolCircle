package com.example.entity;


import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id", nullable = false)
    private Integer id;

    @Column(name = "uid_from", nullable = false)
    private Integer uidFrom;

    @Column(name = "uid_to", nullable = false)
    private Integer uidTo;

    @Lob
    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "time", nullable = false)
    private Instant time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUidFrom() {
        return uidFrom;
    }

    public void setUidFrom(Integer uidFrom) {
        this.uidFrom = uidFrom;
    }

    public Integer getUidTo() {
        return uidTo;
    }

    public void setUidTo(Integer uidTo) {
        this.uidTo = uidTo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

}