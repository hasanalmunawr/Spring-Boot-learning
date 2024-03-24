package hasanalmunawarDev.SpringBasic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        "hasanalmunawarDev.SpringBasic.repository",
        "hasanalmunawarDev.SpringBasic.service",
        "hasanalmunawarDev.SpringBasic.configuration",
})
public class ComponentConfiguration {


}
