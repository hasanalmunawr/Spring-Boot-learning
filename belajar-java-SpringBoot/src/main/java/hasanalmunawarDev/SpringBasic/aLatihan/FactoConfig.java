package hasanalmunawarDev.SpringBasic.aLatihan;

import hasanalmunawarDev.SpringBasic.aLatihan.facto.MajorFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        MajorFactoryBean.class
})
public class FactoConfig {
}
