package hasanalmunawarDev.SpringBasic.Listener;

import hasanalmunawarDev.SpringBasic.event.LoginSuccesEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserListener {

    @EventListener(LoginSuccesEvent.class)
    public void onApplicationEvent(LoginSuccesEvent event) {
        log.info("Succes login for user {}", event.getUser().getUsername());
    }
}
