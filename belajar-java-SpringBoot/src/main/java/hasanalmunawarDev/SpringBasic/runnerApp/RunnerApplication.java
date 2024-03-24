package hasanalmunawarDev.SpringBasic.runnerApp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public interface RunnerApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(RunnerApplication.class, args);
//    }

    void run(ApplicationArguments args) throws Exception;
}
