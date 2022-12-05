package mad.blog.blog.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import mad.blog.blog.dto.BlogDto;
import mad.blog.blog.entities.Blog;
import mad.blog.blog.repositories.BlogRepository;
import mad.blog.blog.services.impl.BlogServiceImpl;

public class BlogServiceTests {
    private BlogRepository repos = Mockito.mock(BlogRepository.class);
    private BlogService service;

    @BeforeEach
    void beforeEach() {
        service = new BlogServiceImpl(repos);
    }

    @Test
    void getBlogTest() {
        Blog returnBlog = Blog.builder()
        .id(1L)
        .title("test title")
        .contents("test contents")
        .created(LocalDateTime.now())
        .updated(LocalDateTime.now())
        .build();

        Mockito.when(repos.findById(1L)).thenReturn(Optional.of(returnBlog));



        BlogDto dto = service.fetch(1L);
        Blog blog = repos.findById(1L).orElseThrow();

        Assertions.assertEquals(dto.getId(), blog.getId());
        Assertions.assertEquals(dto.getTitle(), blog.getTitle());
        Assertions.assertEquals(dto.getContents(), blog.getContents());
        Assertions.assertEquals(dto.getCreated(), blog.getCreated());
        Assertions.assertEquals(dto.getUpdated(), blog.getUpdated());
    }
    
}
