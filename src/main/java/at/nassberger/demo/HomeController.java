package at.nassberger.demo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    Logger log=Logger.getLogger("at.nassberger.demo.MainController");

    @GetMapping("/")
    public String form() {
        log.log(Level.INFO, "calling form() method");
        String html = "<html><head>Einfaches POST Formular</head>"
            + "<body><h1>Mein Formular</h1><hr>"
            + "<form action='./save' method='POST'>"
            + "Vorname: <input type='text' name='firstname'></br>"
            + "Nachname:<input type='text' name='lastname'></br>"
            + "<input type='submit' value='senden'>"
            + "</form>"
            + "</body></html>";
        return html;
    }
        
    @PostMapping("/save")
    public String save(@ModelAttribute UserData data) {
        log.log(Level.INFO, "calling save() method");
        return "ok, recieved data: firstname: " + data.getFirstname() + ", lastname: " + data.getLastname();
    }

    
}
