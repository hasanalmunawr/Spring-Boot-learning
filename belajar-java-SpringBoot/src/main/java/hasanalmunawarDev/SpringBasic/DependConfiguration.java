package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.date.Barr;
import hasanalmunawarDev.SpringBasic.date.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;

@Configuration
@Slf4j
public class DependConfiguration {


    @Bean(name = "firstFoo")
    @Lazy // AKAN DI BUAT KETIKA DI PANGGIL, LEBIH MENGHEMAT MEMORI
    @DependsOn("barrBean") // MENDAHULUKAN PEMBUATAN BARR SEBELUM FOO
    public Foo foo(){
        log.info("create foo");
        return new Foo();
    }


    @Bean(name = "barrBean")
    @Scope("prototype") // akan selalu di buat baru ketika di panggil
    public Barr barr() {
        log.info("create barr");
        return new Barr();
    }

}
