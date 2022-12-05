package mad.blog.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import mad.blog.blog.dto.BlogDto;
import mad.blog.blog.entities.Blog;
import mad.blog.blog.services.BlogService;

@RestController
@RequestMapping("blog")
public class BlogController {

    @Autowired
    BlogService service;

    @Operation(summary = "list indexing", description = "blog listing")
    @GetMapping("")
    List<Blog> index() {
        return service.list();
    }

    @GetMapping("fetch")
    BlogDto fetch(Long id) {
        return service.fetch(id);
    }

    @PostMapping("save")
    BlogDto save(BlogDto post) {
        return service.save(post);
    }

    @DeleteMapping("delete")
    void delete(Long id) {
        service.delete(id);
    }
}
