import com.ssg.board.dao.PostDAO;
import com.ssg.board.dao.PostDAOImpl;
import com.ssg.board.dto.PostDTO;
import com.ssg.board.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServiceTests {

    private PostService postService;

    @BeforeEach
    public void init() {
        postService = PostService.INSTANCE;
    }

    @Test
    public void testInsertService() {
        PostDTO postDTO = PostDTO.builder()
                .title("테스트용 포스팅")
                .content("포스팅 테스트입니다. 제발 잘됐으면 좋헸습니다")
                .writer("고하원")
                .passphrase("원숭이")
                .build();
        long key = postService.write(postDTO);
        System.out.println(key);
    }

    @Test
    public void testUpdateService() {
        PostDTO postDTO = PostDTO.builder()
                .postId(5L)
                .title("테스트용 포스팅")
                .content("포스팅 테스트입니다. 수정합니다.")
                .writer("고하원")
                .passphrase("원숭이")
                .build();
        postService.edit(postDTO, postDTO.getPassphrase());
    }

    @Test
    public void testDeleteService() {
        long postId = 4L;
        String passphrase = "원숭이";
        postService.remove(postId, passphrase);
    }
}
