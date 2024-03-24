package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.configuration.OptionalConfiguration;
import hasanalmunawarDev.SpringBasic.date.Barr;
import hasanalmunawarDev.SpringBasic.date.Foo;
import hasanalmunawarDev.SpringBasic.date.FooBarr;
import hasanalmunawarDev.SpringBasic.date.MultiFoo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

public class OptionalTest {
    
    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(OptionalConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void testOptional() {
        Foo foo = context.getBean(Foo.class);
        FooBarr fooBarr = context.getBean(FooBarr.class);

        Assertions.assertSame(foo, fooBarr.getFoo());
        Assertions.assertNull(fooBarr.getBarr());
    }

    @Test
    void multiFoo() {
        MultiFoo bean = context.getBean(MultiFoo.class);
        Assertions.assertSame(3, bean.getFooList().size());
    }

    @Test
    void beanFactory() {
        ObjectProvider<MultiFoo> beanProvider = context.getBeanProvider(MultiFoo.class);
        System.out.println(beanProvider);

        Map<String, Foo> beansOfType = context.getBeansOfType(Foo.class);
        System.out.println(beansOfType);
    }
}
