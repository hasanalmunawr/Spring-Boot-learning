package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.service.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class AwareTest {

    @Configuration
    @Import(AuthService.class)
    public static class AwareConfiguration{

    }

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(AwareConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void name() {
        AuthService service = context.getBean(AuthService.class);

        Assertions.assertEquals(service.getClass().getName(), service.getBeanName());
        Assertions.assertSame(context, service.getContext());
    }
}
