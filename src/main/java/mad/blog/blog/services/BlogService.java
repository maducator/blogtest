package mad.blog.blog.services;

import java.util.List;

import mad.blog.blog.dto.BlogDto;
import mad.blog.blog.entities.Blog;

public interface BlogService {
    List<Blog> list();
    BlogDto fetch(long l);
    BlogDto save(BlogDto blog);
    void delete(Long id);
    Blog test();
}
