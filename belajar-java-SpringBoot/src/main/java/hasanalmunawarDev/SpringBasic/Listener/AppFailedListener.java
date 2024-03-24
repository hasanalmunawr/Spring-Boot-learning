package hasanalmunawarDev.SpringBasic.Listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
public class AppFailedListener implements ApplicationListener<ApplicationFailedEvent> {

//    @Override
//    public void onApplicationEvent(AppFailedListener event) {
//        log.info("Application started ");
//    }

    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        log.info("Application failed");
    }
}
