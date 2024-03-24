package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.date.Car;
import hasanalmunawarDev.SpringBasic.processor.IdGeneratorBeanPostProcessor;
import hasanalmunawarDev.SpringBasic.processor.PrefixIdGeneratorBeanPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class OrderedTest {

    @Configuration
    @Import({
            Car.class,
            IdGeneratorBeanPostProcessor.class,
            PrefixIdGeneratorBeanPostProcessor.class
    })
    public static class prefixConfiguration{

    }

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(prefixConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void testPrefix() {
        Car bean = context.getBean(Car.class);

        Assertions.assertNotNull(bean.getId());
        Assertions.assertTrue(bean.getId().startsWith("HSN-"));
        System.out.println(bean.getId().toString());
    }
}
