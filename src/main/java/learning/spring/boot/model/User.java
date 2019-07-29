package learning.spring.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "USER_DETAILS")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name")
    @NotNull(message = "The first name provided is either empty or null")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "The last name provided is either empty or null")
    private String lastName;
    
    @Column(name = "email")
    @NotNull(message = "The email id provided is either empty or null")
    @Email(message = "Email entered is not a valid email id")
    private String email;
    
}