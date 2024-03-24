package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.date.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class BeanConfiguration {

    @Bean
    public Foo foo(){
        Foo foo = new Foo();
        log.info("Create bean");
      return  foo;
    }



}
