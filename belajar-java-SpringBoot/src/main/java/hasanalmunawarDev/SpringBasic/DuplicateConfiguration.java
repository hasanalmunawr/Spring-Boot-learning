package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.date.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Slf4j
public class DuplicateConfiguration {

    @Bean(name = "fooSiji")
    public Foo foo1(){
        Foo foo = new Foo();
        log.info("Create Bean 1");
        return foo;
    }
    @Bean(name = "fooDua")
    @Primary // akan di utamakan jika tidak di sebutkan nama method nya
    public Foo foo2(){
        Foo foo = new Foo();
        log.info("Create  Bean 2");
        return foo;
    }

}
