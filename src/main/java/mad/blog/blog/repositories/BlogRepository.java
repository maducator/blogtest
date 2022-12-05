package mad.blog.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mad.blog.blog.entities.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}