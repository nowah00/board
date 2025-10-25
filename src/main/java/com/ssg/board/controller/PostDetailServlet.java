package com.ssg.board.controller;

import lombok.extern.log4j.Log4j2;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * - id로 단건 조회
 * - 상세에서 **수정/삭제 버튼** 제공.
 * */

@WebServlet(name = "Detail", urlPatterns = "/posts/view")
@Log4j2
public class PostDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[/posts/view doGet() 호출]");
    }
}
