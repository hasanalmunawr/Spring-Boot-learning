package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.date.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class BeanTest {
    @Test
    void name() {
        ApplicationContext context = new AnnotationConfigReactiveWebApplicationContext(BeanConfiguration.class);

        Foo foo = context.getBean(Foo.class);
        Foo foo2 = context.getBean(Foo.class);

        Assertions.assertSame(foo2, foo);
    }
    @Test
    void dupliate() {
        ApplicationContext context = new AnnotationConfigReactiveWebApplicationContext(BeanConfiguration.class);

        Foo foo = context.getBean(Foo.class);
        Foo foo2 = context.getBean(Foo.class, "foo2");

        Assertions.assertSame(foo2, foo);
    }

}
