package hasanalmunawarDev.SpringBasic.date;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Server {
    @PostConstruct
    public void start(){
        log.info("Strart server");
    }

    @PreDestroy
    public void stop() {
        log.info("Stop server");
    }
}
