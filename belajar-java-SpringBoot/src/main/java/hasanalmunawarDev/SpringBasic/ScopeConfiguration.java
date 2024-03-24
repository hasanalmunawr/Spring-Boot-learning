package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.date.Barr;
import hasanalmunawarDev.SpringBasic.date.Foo;
import hasanalmunawarDev.SpringBasic.scope.DoubletonScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Slf4j
public class ScopeConfiguration {

    @Bean(name = "barrBean")
    @Scope("prototype") // akan selalu di buat baru ketika di panggil
    public Barr barr() {
        log.info("create barr");
        return new Barr();
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        customScopeConfigurer.addScope("doubleton", new DoubletonScope());
        return customScopeConfigurer;
    }

    @Bean
    @Scope("doubleton")
    public Foo foo() {
        log.info("create foo");
        return new Foo();
    }
}
