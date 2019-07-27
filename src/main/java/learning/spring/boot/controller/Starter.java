/*
** author deepak.mohan
*/
package learning.spring.boot.controller;

import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Starter {

    /**
     * Trying out mapping using variables
     */
    
    private static final String HOME = "home";

    @GetMapping("/")
    public String viewIndex() {
        return HOME;
    }

}