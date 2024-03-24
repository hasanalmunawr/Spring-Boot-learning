package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.configuration.BarrConfiguration;
import hasanalmunawarDev.SpringBasic.configuration.FooConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        FooConfiguration.class,
        BarrConfiguration.class
})
public class MainConfiguration {

}
