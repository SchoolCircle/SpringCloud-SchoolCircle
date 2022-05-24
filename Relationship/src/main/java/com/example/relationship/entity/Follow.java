package com.example.relationship.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 关注类
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自动递增
    private Integer fid;

    private Integer followed;//被关注

    private Integer following;//关注

    @Column(name = "f_time")
    private String followTime;//关注时间
}
