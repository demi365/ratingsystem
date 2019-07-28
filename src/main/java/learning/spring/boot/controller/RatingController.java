package learning.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learning.spring.boot.model.Rating;
import learning.spring.boot.service.RatingsService;

@RestController
@RequestMapping("rating")
public class RatingController {

    @Autowired
    RatingsService ratingsService;

    @RequestMapping("/{user_id}/{book_id}/{rating}")
    public Rating addRating(@PathVariable("user_id") int userId, 
                            @PathVariable("book_id") int bookId,
                            @PathVariable("rating") int rating) {
                                
        return ratingsService.addRating(bookId, userId, rating);

    }
}