package hasanalmunawarDev.belajarSpringLogging;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@Slf4j
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class LoggingTest {

    @Test
    void testNothing() {
        log.info("Learn spring logging");
        log.warn("Nothing special here");
        log.error("I dont know anything");
    }

//    @Test
//    void testLongLogging() {
//        for (int i = 0; i < 100_000; i++) {
//            log.warn("hello san {}", i);
//        }
//    }
}
