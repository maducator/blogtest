package mad.blog.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mad.blog.blog.dto.BlogDto;
import mad.blog.blog.entities.Blog;
import mad.blog.blog.repositories.BlogRepository;
import mad.blog.blog.services.BlogService;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository repos;

    public BlogServiceImpl(@Autowired BlogRepository repos) {
        this.repos = repos;
    }

    public List<Blog> list() {
        return repos.findAll();
    }

    public BlogDto fetch(long id) {
        Blog blog = repos.findById(id).orElse(new Blog());
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