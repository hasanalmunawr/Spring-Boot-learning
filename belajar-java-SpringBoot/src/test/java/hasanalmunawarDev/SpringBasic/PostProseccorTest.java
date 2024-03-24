package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.date.Foo;
import hasanalmunawarDev.SpringBasic.processor.FooBeanFactoryPostProseccor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class PostProseccorTest {

    @Configuration
    @Import(FooBeanFactoryPostProseccor.class)
    public static class ProcessorConfiguration{

    }

    private ConfigurableApplicationContext context;
    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(ProcessorConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void test() {
        Foo foo = context.getBean("foo", Foo.class);
        Assertions.assertNotNull(foo);
    }
}
