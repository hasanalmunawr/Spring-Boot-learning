package hasanalmunawarDev.belajarSpringLogging;

import hasanalmunawarDev.belajarSpringLogging.properties.ApplicationProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@SpringBootApplication
@EnableConfigurationProperties(
		ApplicationProperties.class
)
public class BelajarSpringbootLoggingApplication{

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringbootLoggingApplication.class, args);
	}

}
