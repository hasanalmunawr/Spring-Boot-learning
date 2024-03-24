package hasanalmunawarDev.SpringBasic.configuration;

import hasanalmunawarDev.SpringBasic.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class CustomerConfiguration {

    @Bean
    public CustomerRepository normalCustomerRepository(){
        log.info("create normal");
        return new CustomerRepository();
    }
    @Bean
    public CustomerRepository premiumCustomerRepository(){
        log.info("create premium");
        return new CustomerRepository();
    }

}
