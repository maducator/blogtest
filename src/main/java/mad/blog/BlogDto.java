package mad.blog;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class BlogDto {
    private Long id;
    private String title;
    private String contents;
}
