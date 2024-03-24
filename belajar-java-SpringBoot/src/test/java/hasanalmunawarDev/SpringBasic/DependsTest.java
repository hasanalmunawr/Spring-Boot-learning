package hasanalmunawarDev.SpringBasic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class DependsTest {

    @Test
    void test() {
        ApplicationContext context = new AnnotationConfigReactiveWebApplicationContext(DependConfiguration.class);

    }
}
