package hasanalmunawarDev.SpringBasic;

import hasanalmunawarDev.SpringBasic.Listener.LoginAgainSuccesListener;
import hasanalmunawarDev.SpringBasic.Listener.LoginSuccesListener;
import hasanalmunawarDev.SpringBasic.Listener.UserListener;
import hasanalmunawarDev.SpringBasic.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class ListenerEventTest {
    @Configuration
    @Import({
            UserService.class,
            LoginSuccesListener.class,
            LoginAgainSuccesListener.class,
            UserListener.class
    })
    public static class TestConfiguration {

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testEvent() {

        UserService userService = applicationContext.getBean(UserService.class);
        userService.login("hasan", "rahasia");
        userService.login("hasan", "rahasia");
        userService.login("kurninawan", "salah");

    }
}
