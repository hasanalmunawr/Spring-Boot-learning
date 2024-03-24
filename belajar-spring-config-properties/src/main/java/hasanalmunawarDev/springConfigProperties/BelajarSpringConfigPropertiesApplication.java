package hasanalmunawarDev.springConfigProperties;

import hasanalmunawarDev.springConfigProperties.converter.StringToDateConverter;
import hasanalmunawarDev.springConfigProperties.properties.ApplicationProperties;
import hasanalmunawarDev.springConfigProperties.runner.ApplicationPropertiesRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;

@SpringBootApplication
@EnableConfigurationProperties({
		ApplicationProperties.class
})
public class BelajarSpringConfigPropertiesApplication {

	@Bean
	public ConversionService conversionService(StringToDateConverter stringToDateConverter){
		ApplicationConversionService applicationConversionService = new ApplicationConversionService();
		applicationConversionService.addConverter(stringToDateConverter);
		return  applicationConversionService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringConfigPropertiesApplication.class, args);
	}

}
