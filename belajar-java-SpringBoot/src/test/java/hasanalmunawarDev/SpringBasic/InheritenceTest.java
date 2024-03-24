package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.configuration.OptionalConfiguration;
import hasanalmunawarDev.SpringBasic.service.MerchantService;
import hasanalmunawarDev.SpringBasic.service.MerchantServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class InheritenceTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(InheritanceConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void test() {
        MerchantService bean = context.getBean(MerchantService.class);
        MerchantServiceImpl bean1 = context.getBean(MerchantServiceImpl.class);

        Assertions.assertSame(bean1, bean);
    }
}
