package hasanalmunawarDev.SpringBasic.configuration;

import hasanalmunawarDev.SpringBasic.date.Barr;
import hasanalmunawarDev.SpringBasic.date.Foo;
import hasanalmunawarDev.SpringBasic.date.FooBarr;
import hasanalmunawarDev.SpringBasic.date.MultiFoo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import java.util.Optional;

@Configuration
@Import({
        MultiFoo.class
})
public class OptionalConfiguration {

    @Bean
    @Primary
    public Foo foo(){
        return new Foo();
    }

    @Bean
    public Foo foo2(){
        return new Foo();
    }

    @Bean
    public Foo foo3(){
        return new Foo();
    }

    @Bean
    public FooBarr fooBarr(Optional<Foo> foo, Optional<Barr> barr) {
        return new FooBarr(foo.orElse(null), barr.orElse(null));
    }
}
