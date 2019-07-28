package learning.spring.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
// import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import learning.spring.boot.model.Rating;

// @RepositoryRestResource(collectionResourceRel = "rating", path = "rating")
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    
    List<Rating> findByRating(@Param("rating") String rating);

}