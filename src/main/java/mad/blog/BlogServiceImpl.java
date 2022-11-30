package mad.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    BlogRepository repos;

    public BlogServiceImpl(@Autowired BlogRepository repos) {
        this.repos = repos;
    }

    public List<Blog> list() {
        return repos.findAll();
    }

    public BlogDto fetch(long id) {
        Blog blog = repos.findById(id).orElse(Blog.builder().build());
        return BlogDto.fromBlog(blog);
    }

    public BlogDto save(BlogDto dto) {
        Blog blog = repos.save(dto.toBlog());
        return BlogDto.fromBlog(blog);
    }

    public void delete(Long id) {
        repos.deleteById(id);
    }


}
