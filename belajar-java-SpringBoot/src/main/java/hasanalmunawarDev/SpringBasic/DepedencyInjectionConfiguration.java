package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.date.Barr;
import hasanalmunawarDev.SpringBasic.date.Foo;
import hasanalmunawarDev.SpringBasic.date.FooBarr;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DepedencyInjectionConfiguration {

    @Bean(name = "firstFoo")
    @Primary
    public Foo foo(){
        return new Foo();
    }
    @Bean(name = "secondFoo")
    public Foo foo2(){
        return new Foo();
    }

    @Bean
    public Barr barr() {
        return new Barr();
    }

    @Bean
    public FooBarr fooBarr(@Qualifier("secondFoo") Foo foo, Barr barr){
        return new FooBarr(foo, barr);
    }


}
