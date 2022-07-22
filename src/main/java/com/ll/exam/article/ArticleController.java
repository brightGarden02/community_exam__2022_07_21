package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {


    // 리스트를 보여준다.
    public void showList(Rq rq) {

//        rq.appendBody("게시물 리스트");

        List<ArticleDto> articleDtos = new ArrayList<>();
        articleDtos.add(new ArticleDto(7, "제목 7", "내용 7"));
        articleDtos.add(new ArticleDto(6, "제목 6", "내용 6"));
        articleDtos.add(new ArticleDto(5, "제목 5", "내용 5"));
        articleDtos.add(new ArticleDto(4, "제목 4", "내용 4"));
        articleDtos.add(new ArticleDto(3, "제목 3", "내용 3"));
        articleDtos.add(new ArticleDto(2, "제목 2", "내용 2"));
        articleDtos.add(new ArticleDto(1, "제목 1", "내용 1"));

        rq.setAttr("articles", articleDtos);
        rq.view("usr/article/list");


    }
}
