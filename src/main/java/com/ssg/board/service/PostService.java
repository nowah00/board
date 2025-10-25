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
        log.info("[write() 호출]");

        long post_id = dao.save(post);

        if (post_id > 0) {
            log.info("[" + post_id + " 생성 완료]");
            return post_id;
        } else {
            log.info("[생성 실패]");
            return 0;
        }
    }

    // 비번검증 + 수정
    public void edit(PostDTO post, String passphrase) {
        log.info("[edit() 호출]");

        if (dao.checkPassphrase(post.getPostId(), passphrase)) {
            log.info("[권한 확인 완료]");
            if (dao.update(post)) {
                log.info("[" + post.getPostId() + " 수정 완료]");
            } else {
                log.info("[수정 실패]");
            }
        } else {
            log.info("[권한 확인 실패]");
        }
    }

    // 비번검증 + 삭제
    public void remove(long id, String passphrase) {
        log.info("[remove() 호출]");

        if (dao.checkPassphrase(id, passphrase)) {
            log.info("[권한 확인 완료]");
            if (dao.delete(id)) {
                log.info("[" + id + " 삭제 완료]");
            } else {
                log.info("[삭제 실패]");
            }
        } else {
            log.info("[권한 확인 실패]");
        }
    }
}
