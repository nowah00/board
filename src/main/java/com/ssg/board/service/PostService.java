package com.ssg.board.service;

import com.ssg.board.dao.PostDAO;
import com.ssg.board.dao.PostDAOImpl;
import com.ssg.board.dto.PostDTO;
import lombok.extern.log4j.Log4j2;

@Log4j2
public enum PostService {
    INSTANCE;

    private PostDAO dao;

    PostService() {
        this.dao = new PostDAOImpl();
    }

//    public List<PostDTO> getList(int page, int size) { ... }
//    public PostDTO getDetail(long id) { ... }                  // 조회수 증가 포함

    // 검증 + 저장
    public long write(PostDTO post) {
        long post_id = dao.save(post);
        if (post_id > 0){
            log.info("[" + post_id + " 생성 완료]");
            return post_id;
        } else {
            log.info("[생성 실패]");
            return 0;
        }
    }






//    public void edit(PostDTO post, String passphrase) { ... }  // 비번검증 + 수정
//    public void remove(long id, String passphrase) { ... }     // 비번검증 + 삭제
}
