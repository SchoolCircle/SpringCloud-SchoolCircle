package com.example.relationship.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "friend_ask")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FriendAsk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自动递增
    private Integer aid;//主键

    @Column(name="uid_from")
    private Integer uidFrom;

    @Column(name="uid_to")
    private Integer uidTo;

    @Column(name="is_success")
    private Integer isSuccess;

    @Column(name="success_time")
    private String successTime;

    @Column(name="time")
    private String time;//请求发起时间

    @Column(name = "is_alive")
    @JsonIgnore
    private Integer isAlive;//记录有效性

    @Column(name="is_fail")
    private Integer isFail;
}
