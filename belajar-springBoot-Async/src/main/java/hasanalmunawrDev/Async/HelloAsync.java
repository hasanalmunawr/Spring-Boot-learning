package hasanalmunawrDev.Async;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Configuration
@Slf4j
public class HelloAsync {


    @Async
    @SneakyThrows
    public void hello() {
        Thread.sleep(5L);
        log.info("Run from hello adter 2 seconds {}", Thread.currentThread());
    }

    @Async("singleTaskExecutor")
    @SneakyThrows
    public Future<String> sayHello(final String name) {
        CompletableFuture<String> future = new CompletableFuture<>();
        Thread.sleep(5L);
        future.complete("Hello "+name+" from thread "+Thread.currentThread());
        return future;
    }
}
