package com.ssg.board.dao;

import com.ssg.board.dto.PostDTO;
import java.util.List;
import java.util.Optional;

public interface PostDAO {
    List<PostDTO> findAll(int page, int size);
    boolean countAll();
    Optional<PostDTO> findById(long id);
    long save(PostDTO post);
    boolean  update(PostDTO post);
    boolean  delete(long id);
    boolean checkPassphrase(long id, String passphrase);
}

