package hasanalmunawarDev.SpringBasic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class ApplicationContextTest {

    @Test
    void test() {
        ApplicationContext context = new AnnotationConfigReactiveWebApplicationContext(HelloWorldConfiguration.class);

        Assertions.assertNotNull(context);
    }
}
