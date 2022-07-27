package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

/**
 * ArticleController class 역할
 * 1. 게시물 리스트를 보여준다.
 */

public class ArticleController {

    private ArticleService articleService;

    public ArticleController() {
        articleService = new ArticleService();
    }


    // 리스트를 보여준다.
    public void showList(Rq rq) {

//        rq.appendBody("게시물 리스트");

//        List<ArticleDto> articleDtos = new ArrayList<>();
//        articleDtos.add(new ArticleDto(7, "제목 7", "내용 7"));
//        articleDtos.add(new ArticleDto(6, "제목 6", "내용 6"));
//        articleDtos.add(new ArticleDto(5, "제목 5", "내용 5"));
//        articleDtos.add(new ArticleDto(4, "제목 4", "내용 4"));
//        articleDtos.add(new ArticleDto(3, "제목 3", "내용 3"));
//        articleDtos.add(new ArticleDto(2, "제목 2", "내용 2"));
//        articleDtos.add(new ArticleDto(1, "제목 1", "내용 1"));

        List<ArticleDto> articleDtos = articleService.findAll();

        rq.setAttr("articles", articleDtos);
        rq.view("usr/article/list");


    }

    public void showWrite(Rq rq) {
        rq.view("usr/article/write");
    }

    public void doWrite(Rq rq) {
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

//        rq.appendBody("<div>title : %s</div>".formatted(title));
//        rq.appendBody("<div>body : %s</div>".formatted(body));

        long id = articleService.write(title, body);
        rq.appendBody("%d번 게시물이 생성 되었습니다.".formatted(id));
    }


    public void showDetail(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if(id == 0) {
            rq.appendBody("번호를 입력해주세요.");
            return;
        }


        ArticleDto articleDto = articleService.findById(id);

        if(articleDto == null) {
            rq.appendBody("해당 글이 존재하지 않습니다.");
            return;
        }

        rq.setAttr("article", articleDto);
        rq.view("usr/article/detail");
    }
}
