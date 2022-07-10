package page.lamht.docker1.springbootdocker.modal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

    public Message(String title, String content){
        this.setTitle(title);
        this.setContent(content);
    }

    String title;
    String content;
}
