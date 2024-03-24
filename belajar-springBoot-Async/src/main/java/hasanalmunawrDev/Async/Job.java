package hasanalmunawrDev.Async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;


@Slf4j
@Component
public class Job {


    private final AtomicLong aLong = new AtomicLong(0);
    private final AtomicLong num = new AtomicLong(0);

//    @Scheduled(cron = "*/2 * * * * *") // runing each 2 second
    @Scheduled(cron = "*/5 * * * * *") // runing each 5 second
    public void cron() {
        long incremented = num.incrementAndGet();
        log.info("Run cron every second");
    }

    @Scheduled(cron = "* * * 23 7 *")
    public void birthDayHasan() {
        log.info("Hopelly hasan can be a software engginer");
    }
    /*Document of cron https://crontab.guru/*/

    @Scheduled(timeUnit = TimeUnit.SECONDS, initialDelay = 2, fixedDelay = 4)
    public void runJob() {
        long value = aLong.incrementAndGet();
        log.info("{} Run Job In {}",value, Thread.currentThread().getName());
    }

     @Scheduled(timeUnit = TimeUnit.SECONDS, initialDelayString = "2", fixedDelayString = "4")
    public void runJob2() {
        long value = aLong.incrementAndGet();
        log.info("{} Run Job In {}",value, Thread.currentThread().getName());
    }



   /*Document of @Scheduled = https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/annotation/Scheduled.html*/

    public long getValue() {
        return num.get();
    }
}
