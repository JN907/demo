package at.nassberger.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;

@Controller
public class FormController {

    Logger logger=Logger.getLogger("at.nassberger.demo.FormController");

@GetMapping("/neu/form")
    public String form(Model model) {
        model.addAttribute("message", "Bootstrap Template Form");
        return "form"; 
    }

    @PostMapping("/neu/save")
    public String save(@ModelAttribute UserData data, Model model) {
        logger.log(Level.INFO, "calling save() method");
        logger.log(Level.INFO, "firstname: " + data.getFirstname());
        logger.log(Level.INFO, "lastname: " + data.getLastname());
        model.addAttribute("message", "Data from Template Form");
        model.addAttribute("firstname", data.getFirstname());
        model.addAttribute("lastname", data.getLastname());
        return "save";
    }
}