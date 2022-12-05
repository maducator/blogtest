package mad.blog.blog.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import mad.blog.blog.entities.Blog;

@Builder
@Data
public class BlogDto {
    private Long id;
    private String title;
    private String contents;
    private LocalDateTime updated;
    private LocalDateTime created;

    public static BlogDto fromBlog(Blog blog) {
        return BlogDto.builder()
        .id(blog.getId())
        .title(blog.getTitle())
        .contents(blog.getContents())
        .created(blog.getCreated())
        .updated(blog.getUpdated())
        .build();
    }

    public Blog toBlog() {
        return Blog.builder()
        .id(this.getId())
        .title(this.getTitle())
        .contents(this.getContents())
        .created(this.getCreated())
        .updated(this.getUpdated())
        .build();
    }
}
