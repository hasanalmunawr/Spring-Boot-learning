package hasanalmunawrDev.Async;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class HelloAsyncTest {

    @Autowired
    private HelloAsync helloAsync;

    @Test
    void test() throws InterruptedException {
        for (int i = 0; i < 16; i++) {
            helloAsync.hello();
        }
        log.info("Call after helloAsync() {}", Thread.currentThread());
        Thread.sleep(Duration.ofSeconds(5));
    }

    @Test
    void testFuture() throws ExecutionException, InterruptedException {

        Future<String> future = helloAsync.sayHello("Hasan");
        log.info("Call after method sayHello(Hasan)");
        String value = future.get();
        log.info(value);

    }
}