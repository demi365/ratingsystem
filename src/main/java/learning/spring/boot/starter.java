package learning.spring.boot;

import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class starter {

    /**
     * Trying out mapping using variables
     */
    
    private static final String HOME = "home";

    @RequestMapping("/")
    public String viewIndex() {
        return HOME;
    }

}