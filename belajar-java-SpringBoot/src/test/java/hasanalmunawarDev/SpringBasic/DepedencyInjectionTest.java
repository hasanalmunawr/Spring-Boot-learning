package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.date.Barr;
import hasanalmunawarDev.SpringBasic.date.Foo;
import hasanalmunawarDev.SpringBasic.date.FooBarr;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class DepedencyInjectionTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(DepedencyInjectionConfiguration.class);
    }

    @Test
    void withoutDI() {
        Foo foo = new Foo();
        Barr barr = new Barr();

        FooBarr fooBarr = new FooBarr(foo, barr);
        Assertions.assertSame(foo, fooBarr.getFoo());
    }

    @Test
    void withDI() {
        Foo foo = context.getBean("firstBean",Foo.class);
        Barr barr = context.getBean(Barr.class);

        FooBarr fooBarr = context.getBean(FooBarr.class);

        Assertions.assertSame(foo, fooBarr.getFoo());
        Assertions.assertSame(barr, fooBarr.getBarr());

    }
    @Test
    void depedency() {
        Foo foo = context.getBean("secondFoo",Foo.class);
        Foo foo1 = context.getBean("firstFoo", Foo.class);
        Barr barr = context.getBean(Barr.class);

        FooBarr fooBarr = context.getBean(FooBarr.class);

        Assertions.assertSame(foo, fooBarr.getFoo());
        Assertions.assertNotSame(foo1, fooBarr.getFoo());

    }

}
