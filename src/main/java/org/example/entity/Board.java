package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private Long num; // 1 2 3 4 5(자동증가)
    private String title; //제목
    private String content; // 내용
    private String writer; // 이름, 아이디, 비번
    private int cnt; // 조회수
    private Date indate; // 작성일
    // setter, getter, 생성자, toString()
    // Lombok API

}
