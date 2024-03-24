package hasanalmunawarDev.SpringBasic.Listener;

import hasanalmunawarDev.SpringBasic.event.LoginSuccesEvent;
import hasanalmunawarDev.SpringBasic.event.RegisterSuccesEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StudentRegisListener {

    @EventListener(RegisterSuccesEvent.class)
    public void onApplicationEvent(RegisterSuccesEvent event) {
        log.info("Succes login for user {}", event.getStudent().getName());
    }
}
