package hasanalmunawarDev.SpringBasic.application;

import hasanalmunawarDev.SpringBasic.date.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class WithoutSpringTest {

    private ConfigurableApplicationContext context;


    @Configuration
    @Import(FooApplication.class)
    public static class spirngCnofiguration{

    }

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(spirngCnofiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void name() {
        Foo foo = context.getBean(Foo.class);
    }
}
