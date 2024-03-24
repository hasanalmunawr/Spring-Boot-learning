package hasanalmunawarDev.SpringBasic.Listener;

import hasanalmunawarDev.SpringBasic.event.RegisterSuccesEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RegistSuccesListener implements ApplicationListener<RegisterSuccesEvent> {
    @Override
    public void onApplicationEvent(RegisterSuccesEvent event) {
      log.info("succes register for {}", event.getStudent().getName());
    }
}
