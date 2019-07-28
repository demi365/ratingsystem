package learning.spring.boot.dao;

import org.springframework.data.repository.CrudRepository;

import learning.spring.boot.model.User;

public interface UserDAO extends CrudRepository<User, Integer> {
    
}