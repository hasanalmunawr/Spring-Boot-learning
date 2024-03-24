package hasanalmunawarDev.springBootValidation;

import hasanalmunawarDev.springBootValidation.properties.DatabaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({
		DatabaseProperties.class
})
@SpringBootApplication
public class BelajarSpringBootValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringBootValidationApplication.class, args);
	}

}
