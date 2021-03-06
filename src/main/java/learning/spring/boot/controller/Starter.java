/*
** author deepak.mohan
*/
package learning.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import learning.spring.boot.repository.UserRepository;

@Controller
public class Starter {

    /**
     * Trying out mapping using variables
     */
    
    private static final String HOME = "/WEB-INF/home.jsp";
    @Autowired
    UserRepository userRepo;

    @GetMapping("/")
    public String viewIndex() {
        return HOME;
    }

}