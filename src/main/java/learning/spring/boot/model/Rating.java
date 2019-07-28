package learning.spring.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "RATINGS")
public class Rating {

    @Id
    @Column(name = "RATING_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ratingId;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @Column(name = "RATING")
    @NotNull(message = "Please specify a rating between 1 and 5 inclusive")
    @Min(value = 1, message = "Please enter a rating greater than 0")
    @Max(value = 5, message = "Please enter a rating leser than 1")
    private int rating;

}