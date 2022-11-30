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

    public Blog fetch(long id) {
        return repos.findById(id).orElse(Blog.builder().build());
    }

    public Blog save(BlogDto dto) {
        Blog blog = Blog.builder()
        .id(dto.getId())
        .title(dto.getTitle())
        .contents(dto.getContents())
        .build();
        return repos.save(blog);
    }

    public void delete(Long id) {
        repos.deleteById(id);
    }


}
