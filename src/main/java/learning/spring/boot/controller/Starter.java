/*
** author deepak.mohan
*/
package learning.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import learning.spring.boot.dao.UserDAO;
import learning.spring.boot.model.User;

@Controller
public class Starter {

    /**
     * Trying out mapping using variables
     */
    
    private static final String HOME = "/WEB-INF/home.jsp";
    @Autowired
    UserDAO userDAO;

    @GetMapping("/")
    public String viewIndex() {
        return HOME;
    }

    @GetMapping("/saveUser")
    public String saveUserDetails(User user) {
        userDAO.save(user);
        return HOME;
    }

    @RequestMapping("userDetails")
    public ModelAndView viewUserDetails() {
        ModelAndView display = new ModelAndView("/WEB-INF/display.jsp");
        return display;
    }

    @RequestMapping("user/{uid}")
    public ModelAndView allUserDetails(@PathVariable("uid") int id) {
        ModelAndView display = new ModelAndView("/WEB-INF/viewUserDetails.jsp");
        display.addObject("users",userDAO.findById(id));
        return display;
    }

}