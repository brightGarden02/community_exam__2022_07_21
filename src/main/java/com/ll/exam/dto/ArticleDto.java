package com.ll.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ArticleDto class 역할
 * 1. 라우팅(교통정리)하기 위함.
 */

@ToString
@AllArgsConstructor
public class ArticleDto {

    @Getter @Setter
    private long id;

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String body;

}
