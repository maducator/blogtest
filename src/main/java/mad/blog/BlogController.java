package mad.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("blog")
public class BlogController {
    @Autowired
    BlogService service;

    @GetMapping("")
    List<Blog> index() {
        return service.list();
    }

    @GetMapping("fetch")
    Blog fetch(Long id) {
        return service.fetch(id);
    }

    @GetMapping("save")
    Blog save(BlogDto blog) {
        return service.save(blog);
    }

    @GetMapping("delete")
    void delete(Long id) {
        service.delete(id);
    }
}
