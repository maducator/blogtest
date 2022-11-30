package mad.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(BlogController.class)
public class BlogControllerTests {

    @Autowired
    MockMvc mvc;

    @MockBean
    BlogService service;

    @BeforeEach
    void beforeEach() {
        Blog first = Blog.builder()
            .id(1L)
            .title("테스트 타이틀")
            .contents("테스트 컨텐츠를 적당히 씁니다.").build();
        BDDMockito.given(service.fetch(1L)).willReturn(first);
    }

    @Test
    void getBlogTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/blog/fetch?id=1"))
            .andExpect(status().isOk())
            .andDo(print())
            .andExpect(jsonPath("$.title").exists())
            .andExpect(jsonPath("$.contents").exists());
        verify(service).getBlog(1L);
    }
}