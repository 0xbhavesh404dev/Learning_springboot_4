package net.engineeringdigest.journalApp;



import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dog {

    public String work(){
        return "BHAW BHAW BHAW!!!";
    }
}
