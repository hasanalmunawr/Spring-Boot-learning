package hasanalmunawarDev.SpringBasic.commandApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public interface CommandApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(CommandApplication.class, args);
//    }

    void run(String... args) throws Exception;
}
