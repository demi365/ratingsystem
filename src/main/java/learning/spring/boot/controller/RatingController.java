package learning.spring.boot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learning.spring.boot.model.Rating;
import learning.spring.boot.service.RatingsService;

@RestController
@RequestMapping("rating")
public class RatingController {

    @Autowired
    RatingsService ratingsService;

    @PutMapping("/{user_id}/{book_id}/{rating}")
    public Rating saveOrUpdateRating(
        @Valid @RequestBody @PathVariable("user_id") int userId, 
        @Valid @RequestBody @PathVariable("book_id") int bookId,
        @Valid @RequestBody @PathVariable("rating") int rating) {
        
        return ratingsService.saveOrUpdateRating(userId, bookId, rating);

    }

    @PostMapping("/{user_id}/{book_id}/{rating}")
    public Rating saveRating(
        @Valid @RequestBody @PathVariable("user_id") int userId, 
        @Valid @RequestBody @PathVariable("book_id") int bookId,
        @Valid @RequestBody @PathVariable("rating") int rating) {
        
        return ratingsService.saveOrUpdateRating(userId, bookId, rating);

    }

    @DeleteMapping("/{rating_id}")
    public void deleteRating(@PathVariable("rating_id") int rating_id) {
                       
        ratingsService.deleteRating(rating_id);

    }

    @GetMapping("/{rating_id}")
    public void getRating(@PathVariable("rating_id") int rating_id) {
                           
        ratingsService.fetchRating(rating_id);

    }

    @GetMapping("/")
    public void getRating() {
                           
        ratingsService.fetchAllRating();

    }
    
}