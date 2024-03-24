package hasanalmunawarDev.SpringBasic.event;

import hasanalmunawarDev.SpringBasic.date.User;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;

@Getter
public class LoginSuccesEvent extends ApplicationEvent {

    private final User user;

    public LoginSuccesEvent(User user) {
        super(user);
        this.user = user;
    }
}
