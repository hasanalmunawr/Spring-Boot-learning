package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.date.Connection;
import hasanalmunawarDev.SpringBasic.date.Server;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class LifeCycleTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(LifeCycleConfiguration.class);
        context.registerShutdownHook();
    }

    @AfterEach
    void tearDown() {
//        context.close();
    }

    @Test
    void test() {
        Connection bean = context.getBean(Connection.class);
    }

    @Test
    void server() {
        Server bean = context.getBean(Server.class);
    }
}
