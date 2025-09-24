package at.nassberger.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    
    Logger logger=Logger.getLogger("at.nassberger.demo.LoginController");  
    private static String my_passwort = "passwort";
    private static String my_username = "jules";

    @GetMapping("/login")   
    public String login() {
        return "login";
    }

    @PostMapping("/check")
    public String check(@RequestParam String username, @RequestParam String passwort, Model model) {
        logger.log(Level.INFO, "calling check() method");
        logger.log(Level.INFO, "Username: " + username);
        logger.log(Level.INFO, "Passwort: " + passwort);

        if (passwort.equals(my_passwort)) {
            model.addAttribute("message", "Login check ok");   
        } else {
            model.addAttribute("message", "Login check failed");
        }
        
        model.addAttribute("username", username);
        model.addAttribute("passwort", passwort);
        return "check";
    }
}
