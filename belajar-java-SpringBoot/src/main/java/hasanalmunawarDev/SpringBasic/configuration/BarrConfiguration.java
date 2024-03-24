package hasanalmunawarDev.SpringBasic.configuration;

import hasanalmunawarDev.SpringBasic.date.Barr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class BarrConfiguration {

    @Bean
    public Barr barr(){
        log.info("crate barr");
        return new Barr();
    }
}
