package learning.spring.boot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learning.spring.boot.exceptions.RecordNotFoundException;
import learning.spring.boot.model.Book;
import learning.spring.boot.model.Rating;
import learning.spring.boot.model.User;
import learning.spring.boot.repository.BookRepository;
import learning.spring.boot.repository.RatingRepository;
import learning.spring.boot.repository.UserRepository;

@Service
public class RatingsService {

    @Autowired
    BookRepository bookRepo;

    @Autowired
    UserRepository userRepo;
    
    @Autowired
    RatingRepository ratingRepo;

    @Transactional
    public Rating saveOrUpdateRating(int userId, int bookId, int rating) {

        Book book = bookRepo.findById(bookId)
                .orElseThrow(RecordNotFoundException::new);
        
        User user = userRepo.findById(userId)
                .orElseThrow(RecordNotFoundException::new);
        
        List<Rating> reviews = ratingRepo.findByBook(book);

        Rating review;

        if(reviews == null) {
            review = Rating.builder().book(book)
                            .user(user).rating(rating).build();
            
            ratingRepo.save(review);

        } else {
            
            for(Rating r : reviews) {

                if(r.getUser().getUser_id() == userId){
                    
                    r.setRating(rating);
                    ratingRepo.save(r);

                    return r;

                }

            }
            review = Rating.builder().book(book)
                            .user(user).rating(rating).build();

            ratingRepo.save(review);

        }
        return review;
    }

    @Transactional
    public void deleteRating(int rating_id) {

        ratingRepo.deleteById(rating_id);

    }

    @Transactional
    public Rating fetchRating(int rating_id) {

        return ratingRepo.findById(rating_id)
                .orElseThrow(RecordNotFoundException::new);

    }

    @Transactional
    public List<Rating> fetchAllRating() {

        return ratingRepo.findAll();

    }

}