package com.ssg.board.controller;

import lombok.extern.log4j.Log4j2;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Edit", urlPatterns = "/posts/edit")
@Log4j2
public class PostEditFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[/posts/edit doGet() 호출]");
    }
}
