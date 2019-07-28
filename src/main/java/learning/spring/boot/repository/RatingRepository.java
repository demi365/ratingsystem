package learning.spring.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
// import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import learning.spring.boot.model.Book;
import learning.spring.boot.model.Rating;
import learning.spring.boot.model.User;

// @RepositoryRestResource(collectionResourceRel = "rating", path = "rating")
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    
    List<Rating> findByRating(@Param("rating") int rating);

    List<Rating> findByBook(@Param("book") Book book);

    List<Rating> findByUser(@Param("user") User user);
    
}