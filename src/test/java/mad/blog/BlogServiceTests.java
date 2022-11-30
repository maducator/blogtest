package mad.blog;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BlogServiceTests {
    private BlogRepository repos = Mockito.mock(BlogRepository.class);
    private BlogService service;

    @BeforeEach
    void beforeEach() {
        service = new BlogServiceImpl(repos);

        Blog blog = Blog.builder()
        .id(1L)
        .title("test title")
        .contents("test contents")
        .build();

        Mockito.when(repos.findById(1L)).thenReturn(Optional.of(blog));
    }

    @Test
    void getBlogTest() {
        Blog dto = service.fetch(1L);
        Blog blog = repos.findById(1L).orElseThrow();

        Assertions.assertEquals(dto.getId(), blog.getId());
        Assertions.assertEquals(dto.getTitle(), blog.getTitle());
        Assertions.assertEquals(dto.getContents(), blog.getContents());
    }
    
}
