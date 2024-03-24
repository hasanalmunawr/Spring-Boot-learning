package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.date.Barr;
import hasanalmunawarDev.SpringBasic.date.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class ScopeTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigReactiveWebApplicationContext(ScopeConfiguration.class);
    }

    @Test
    void prototypeScope() {
        Barr bean1 = applicationContext.getBean(Barr.class);
        Barr bean2= applicationContext.getBean(Barr.class);
        Barr bean3 = applicationContext.getBean(Barr.class);

        Assertions.assertNotSame(bean1, bean2);
        Assertions.assertNotSame(bean1, bean3);
    }

    @Test
    void doubleTonScope() {
        Foo foo = applicationContext.getBean(Foo.class);
        Foo foo2 = applicationContext.getBean(Foo.class);
        Foo foo3 = applicationContext.getBean(Foo.class);
        Foo foo4 = applicationContext.getBean(Foo.class);

        Assertions.assertSame(foo, foo3);
        Assertions.assertSame(foo2, foo4);
    }
}

