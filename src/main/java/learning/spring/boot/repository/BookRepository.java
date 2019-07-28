package learning.spring.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import learning.spring.boot.model.Book;

@RepositoryRestResource(collectionResourceRel = "book", path = "book")
public interface BookRepository extends JpaRepository<Book, Integer> {
    
    List<Book> findByBookName(@Param("bookName") String bookName);

}