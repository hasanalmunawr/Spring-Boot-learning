package hasanalmunawarDev.springConfigProperties.appproperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = AppPropertiesTest.TestApplication.class)
public class AppPropertiesTest {

    @Autowired
    private Environment environment;

//    @Test
//    void test() {
//        String property = environment.getProperty("application.name");
//        Assertions.assertEquals("Belajar Spring boot config", property);
//    }

    @SpringBootApplication
    public static class TestApplication{

    }

}
