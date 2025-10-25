package com.ssg.board.controller;

import lombok.extern.log4j.Log4j2;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *- **GET**: 기존 값 바인딩된 폼 출력(제목/내용만 수정  하고  작성자 수정은 금지)
 * - **POST**: **비밀번호(passphrase) 확인** 후 업데이트. 불일치 시 오류 메시지.
 * - 성공 시 상세 페이지로 리다이렉트.
 * */

@WebServlet(name = "Update", urlPatterns = "/posts/update")
@Log4j2
public class PostUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[/posts/update doGet() 호출]");
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[/posts/update doPost() 호출]");
        super.doPost(req, resp);
    }
}
