package hasanalmunawarDev.SpringBasic.Listener;

import hasanalmunawarDev.SpringBasic.event.LoginSuccesEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoginAgainSuccesListener implements ApplicationListener<LoginSuccesEvent> {
    @Override
    public void onApplicationEvent(LoginSuccesEvent event) {
      log.info("Succes login again by user {}", event.getUser().getUsername());
    }
}
