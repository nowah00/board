package com.ssg.board.dao;

import com.ssg.board.dto.PostDTO;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Log4j2
public class PostDAOImpl implements PostDAO {
    @Override
    public List<PostDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public boolean countAll() {
        return false;
    }

    @Override
    public Optional<PostDTO> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long save(PostDTO post) {
        log.info("[save() 호출]");

        String sql = "INSERT INTO board_post(title, content, writer, passphrase) VALUES(?,?,?,?)";

        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setString(2, post.getContent());
            preparedStatement.setString(3, post.getWriter());
            preparedStatement.setString(4, post.getPassphrase());
            int affected = preparedStatement.executeUpdate();
            if (affected != 1) return 0;

            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                return keys.next() ? keys.getLong(1) : 0; // post_id가 첫 컬럼이라고 가정
            }
        } catch (Exception e) {
            log.info("save() 실행 실패");
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean update(PostDTO post) {
        log.info("[update() 호출]");

        String sql = "UPDATE board_post SET title = ?, content = ?, writer = ?, passphrase = ? WHERE post_id = ?";

        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setString(2, post.getContent());
            preparedStatement.setString(3, post.getWriter());
            preparedStatement.setString(4, post.getPassphrase());
            preparedStatement.setLong(5, post.getPostId());
            return preparedStatement.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        log.info("[delete() 호출]");

        String sql = "DELETE FROM board_post WHERE post_id = ?";

        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkPassphrase(long id, String passphrase) {
        log.info("[checkPassphrase() 호출]");

        String sql = "SELECT * FROM board_post WHERE post_id = ? AND passphrase = ?";

        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, passphrase);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
