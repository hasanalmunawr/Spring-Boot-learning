package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.date.cyc.CycA;
import hasanalmunawarDev.SpringBasic.date.cyc.CycB;
import hasanalmunawarDev.SpringBasic.date.cyc.CycC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CycConfiguration {
    @Bean
    public CycA cycA(CycB b) {
        return new CycA(b);
    }
    @Bean
    public CycB cycB(CycC c) {
        return new CycB(c);
    }
    @Bean
    public CycC cycC(CycA a) {
        return new CycC(a);
    }



}
