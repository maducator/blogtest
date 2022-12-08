package mad.blog.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mad.blog.blog.entities.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query(value="""
        select *
        from blog
        where id < 100
            """, nativeQuery=true)
    Blog test();
}
