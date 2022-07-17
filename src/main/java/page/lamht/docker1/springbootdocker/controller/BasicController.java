package page.lamht.docker1.springbootdocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/")
    String getHelloWorld() {
        return "Java Hello World";
    }

}

