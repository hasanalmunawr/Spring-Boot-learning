package hasanalmunawarDev.springConfigProperties.profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ProfileTest.TestApplication.class)
@ActiveProfiles({"local"})
public class ProfileTest {

    @Autowired
    private TestApplication.SyHello syHello;

    @Test
    void testLocal() {
        Assertions.assertEquals("hello hasan from local profile", syHello.say("hasan"));
    }
//    @Test
//    void testProduction() {
//        Assertions.assertEquals("hello hasan from production profile", syHello.say("hasan"));
//    }

    @SpringBootApplication
    public static class TestApplication {


        public interface SyHello {
            String say(String name);
        }

        @Component
        @Profile({"local"})
        public static class LocalSyHello implements SyHello {

            @Override
            public String say(String name) {
                return "hello " + name + " from local profile";
            }
        }

        @Component
        @Profile({"production"})
        public static class productionSyHello implements SyHello {

            @Override
            public String say(String name) {
                return "hello " + name + " from production profile";
            }
        }
    }
}
