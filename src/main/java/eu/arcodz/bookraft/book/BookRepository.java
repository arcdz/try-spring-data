package eu.arcodz.bookraft.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "books", path = "books", rel="books")
public interface BookRepository extends JpaRepository<Book, Long> {

        @RestResource(path = "title", rel = "title")
        List<Book> findByTitleIsLike(@Param("title") String title);
}
