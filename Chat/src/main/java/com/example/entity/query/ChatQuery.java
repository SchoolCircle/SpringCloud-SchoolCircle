package com.example.entity.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatQuery {
    private Integer pageNum = 1;//当前页码
    private Integer pageSize = 2;//每页记录数
    private Integer id1;//用户id1
    private Integer id2;//用户id2
}
