package learning.spring.boot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Rating addRating(int bookId, int userId, int rating) {

        Book book = bookRepo.findById(bookId).get();
        
        User user = userRepo.findById(userId).get();

        Rating review = Rating.builder().book(book)
                            .user(user).rating(rating).build();

        ratingRepo.save(review);

        return review;

    }

}