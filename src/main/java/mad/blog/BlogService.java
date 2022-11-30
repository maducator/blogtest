package mad.blog;

import java.util.List;

public interface BlogService {
    List<Blog> list();
    Blog fetch(long l);
    Blog save(BlogDto blog);
    void delete(Long id);
}
