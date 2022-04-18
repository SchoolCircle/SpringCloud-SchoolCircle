package com.example.chat.entity.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatQuery {
    private Integer pageNum = 1;//当前页码
    private Integer pageSize = 2;//每页记录数
    private Integer uid_from;//用户id1
    private Integer uid_to;//用户id2
}
