package page.lamht.docker1.springbootdocker.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import page.lamht.docker1.springbootdocker.modal.Message;

import java.util.Arrays;
import java.util.List;
@CrossOrigin
@RestController @RequestMapping("/message")
public class MessageController {

    @GetMapping("/list")
    List<Message> list() {
        return Arrays.asList(new Message("Hello","Hey how are you man"),
                new Message("Hi","Yo yo yo man"),
                new Message("Bye","see you soon man"));
    }

    @GetMapping("/one")
    Message one() {
        return new Message("COJ", "Come On James!");
    }

}
