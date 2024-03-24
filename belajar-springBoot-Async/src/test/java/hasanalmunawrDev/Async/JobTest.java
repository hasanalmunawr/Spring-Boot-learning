package hasanalmunawrDev.Async;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.helpers.TransformedHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobTest {

    @Autowired
    private Job job;

    @Test
    void job() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(8));
        assertEquals(2L, job.getValue());
    }

    @Test
    void job2() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(12));
        assertEquals(6L, job.getValue());
    }

    @Test
    void cron() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(10));
        assertEquals(2L, job.getValue());

    }
}