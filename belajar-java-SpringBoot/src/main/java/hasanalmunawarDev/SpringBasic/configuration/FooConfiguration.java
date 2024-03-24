package hasanalmunawarDev.SpringBasic.configuration;


import hasanalmunawarDev.SpringBasic.date.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class FooConfiguration {

    @Bean
    public Foo foo(){
        log.info("crate foo");
        return new Foo();
    }
}
