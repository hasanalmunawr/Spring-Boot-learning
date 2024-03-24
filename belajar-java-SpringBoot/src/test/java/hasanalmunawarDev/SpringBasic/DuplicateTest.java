package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.date.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class DuplicateTest {

    @Test
    void duplicate() {
        ApplicationContext context = new AnnotationConfigReactiveWebApplicationContext(DuplicateConfiguration.class);


        Foo foo = context.getBean("fooSiji", Foo.class);
        Foo foo2 = context.getBean("fooDua",Foo.class);
        Foo foo3 = context.getBean(Foo.class);

        Assertions.assertNotSame(foo, foo3);
        Assertions.assertSame(foo2, foo3);


    }
}
