package at.nassberger.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    Logger logger=Logger.getLogger("at.nassberger.demo.LoginController");  
    private static String my_passwort = "passwort";
    private static String my_username = "jules";

    @Autowired
    private UserService service;

    @GetMapping("/login")   
    public String login() {
        return "login";
    }

    @PostMapping("/check")
    public String check(@RequestParam String username, @RequestParam String passwort, Model model) {
        logger.log(Level.INFO, "calling check() method");
        logger.log(Level.INFO, "Username: " + username);
        logger.log(Level.INFO, "Passwort: " + passwort);

        User user=service.findUser(username);
        if (user==null) {
            logger.log(Level.INFO, "user not found: " + username);
            model.addAttribute("message", "User not found");   
            return "login";
        } else {
            logger.log(Level.INFO, "user found: " + user.getUsername());
             
            if (passwort.equals(user.getPassword())) {
                model.addAttribute("message", "Login check ok");   
            } else {
                model.addAttribute("message", "Login check failed");
            }
        }
        
        model.addAttribute("username", username);
        model.addAttribute("passwort", passwort);
        if (user.getAdmin()){
 return "admin";    
} else {
 return "user";    
}

    }


    }
