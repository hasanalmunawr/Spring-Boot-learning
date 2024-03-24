package hasanalmunawarDev.Aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class BelajarSpringBootAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringBootAopApplication.class, args);
	}

}
