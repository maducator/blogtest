package mad.blog;

import java.util.List;

public interface BlogService {
    List<Blog> list();
    BlogDto fetch(long l);
    BlogDto save(BlogDto blog);
    void delete(Long id);
}
