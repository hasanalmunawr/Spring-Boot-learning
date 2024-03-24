package hasanalmunawrDev.belajarspringBootmonitoring;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class MyScheduledTask {

    @Autowired
    private MeterRegistry meterRegistry;

    @Scheduled(timeUnit = TimeUnit.SECONDS, fixedRate = 100)
    public void hello() {
        meterRegistry.counter("my.scheduled.tasl").increment();
        System.out.println("Hello, good mornig sirr");
    }
}
