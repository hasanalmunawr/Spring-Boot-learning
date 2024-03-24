package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.date.Car;
import hasanalmunawarDev.SpringBasic.processor.IdGeneratorBeanPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class BeanprocessorTest {

    @Configuration
    @Import({
            Car.class,
            IdGeneratorBeanPostProcessor.class // kunci utama untuk mengisi ID
    })
    public static class testConfiguration{

    }

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(testConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void test() {
        Car bean = context.getBean(Car.class);
        Assertions.assertNotNull(bean.getId());
        System.out.println(bean.getId());
    }
}
