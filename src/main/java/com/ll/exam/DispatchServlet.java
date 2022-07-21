package com.ll.exam;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("usr/*")
public class DispatchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().append("Work?");

        Rq rq = new Rq(req, resp);

        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();


        /**
         * getRequestURI는
         * Http://localhost:8081/usr/article/list/free?page=1 에서
         * /usr/article/list/free 부분만 가져온다.
         */
        String url = req.getRequestURI();

        switch (url) {
            case "/usr/article/list/free":
                articleController.showList(rq);
                break;
            case "/usr/member/login":
                memberController.showList(rq);
                break;
        }

    }



}
