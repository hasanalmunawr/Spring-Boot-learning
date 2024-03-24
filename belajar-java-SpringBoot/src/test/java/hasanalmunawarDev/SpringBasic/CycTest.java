package hasanalmunawarDev.SpringBasic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class CycTest {

    @Test
    void test() {
//        Assertions.th
        ApplicationContext context = new AnnotationConfigReactiveWebApplicationContext(CycConfiguration.class);

    }
}
