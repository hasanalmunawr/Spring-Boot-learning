package hasanalmunawarDev.springConfigProperties.value;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;


@SpringBootTest(classes = ValueTest.TestApplication.class)
public class ValueTest {

    @Autowired
    private TestApplication.ApplicationProperties properties;

    @Autowired
    private TestApplication.SystemProperties systemProperties;

//    @Test
//    void testValue() {
//        Assertions.assertEquals("Belajar Spring Boot config", properties.getName());
//        Assertions.assertEquals(1, properties.getVersion());
//        Assertions.assertEquals(false, properties.isProductionMode());
//    }

    @Test
    void testSystemProperties() {
        Assertions.assertEquals("${JAVA_HOME}", systemProperties.getJavaHome());
    }

    @Configuration
    public static class TestApplication {

        @Component
        @Getter
        public static class SystemProperties {

            @Value("${JAVA_HOME}")
            private String javaHome;

        }

        @Component
        @Getter
        public static class ApplicationProperties {

            @Value("${application.name}")
            private String name;

            @Value("${application.version}")
            private Integer version;

            @Value("${application.production-mode}")
            private boolean productionMode;

        }

    }

}


