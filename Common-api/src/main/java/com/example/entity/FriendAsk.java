package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;


@Table(name = "friend_ask")
@Entity
public class FriendAsk {
    @Id
    @Column(name = "uid_from", nullable = false)
    private Integer id;

    @Column(name = "uid_to", nullable = false)
    private Integer uidTo;

    @Column(name = "is_success", nullable = false)
    private Integer isSuccess;

    @Column(name = "success_time")
    private Instant successTime;

    @Column(name = "time", nullable = false)
    private Instant time;

    @Column(name = "is_alive", nullable = false)
    private Integer isAlive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUidTo() {
        return uidTo;
    }

    public void setUidTo(Integer uidTo) {
        this.uidTo = uidTo;
    }

    public Integer getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Integer isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Instant getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Instant successTime) {
        this.successTime = successTime;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public Integer getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Integer isAlive) {
        this.isAlive = isAlive;
    }

}