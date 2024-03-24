package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.service.MerchantService;
import hasanalmunawarDev.SpringBasic.service.MerchantServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MerchantServiceImpl.class)
public class InheritanceConfiguration {
}
