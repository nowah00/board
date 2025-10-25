import com.ssg.board.dao.PostDAO;
import com.ssg.board.dao.PostDAOImpl;
import com.ssg.board.dto.PostDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DAOTests {
    private PostDAO postDAO;

    @BeforeEach
    public void init() {
        postDAO = new PostDAOImpl();
    }

    @Test
    public void testInsert() {
        PostDTO postDTO = PostDTO.builder()
                .title("테스트용 포스팅")
                .content("포스팅 테스트입니다. 제발 잘됐으면 좋헸습니다")
                .writer("고하원")
                .passphrase("원숭이")
                .build();
        long key = postDAO.save(postDTO);
        System.out.println(key);
    }

    @Test
    public void testUpdate() {
        PostDTO postDTO = PostDTO.builder()
                .postId(3L)
                .title("테스트용 포스팅")
                .content("포스팅 테스트입니다. 수정합니다.")
                .writer("고하원")
                .passphrase("원숭이")
                .build();
        boolean updateComplete = postDAO.update(postDTO);
        if (updateComplete) {
            System.out.println("업데이트 완료");
        } else {
            System.out.println("업데이트 실패");
        }
    }

    @Test
    public void testDelete() {
        long postId = 4L;
        boolean deleteComplete = postDAO.delete(postId);
        if (deleteComplete) {
            System.out.println("삭제 완료");
        } else {
            System.out.println("삭제 실패");
        }
    }

    @Test
    public void testCheckPassphrase() {
        long postId = 4L;
        String passphrase = "원숭이";
        boolean checkPassphrase = postDAO.checkPassphrase(postId, passphrase);
        if (checkPassphrase) {
            System.out.println("권한 확인 완료");
        } else {
            System.out.println("권한 확인 실패");
        }
    }


}
