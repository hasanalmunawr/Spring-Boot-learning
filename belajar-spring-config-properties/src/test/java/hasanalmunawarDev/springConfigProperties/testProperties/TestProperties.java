package hasanalmunawarDev.springConfigProperties.testProperties;

import hasanalmunawarDev.springConfigProperties.sampleProperties.SamplePropertiesTest;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

@TestPropertySources({
        @TestPropertySource("classpath:/test.properties"),
        @TestPropertySource("classpath:/sample.properties")
}) // THE KEY FOR TEST BOTH OF PROPERTIES
@SpringBootTest(classes = {TestProperties.TestApplication.class,SamplePropertiesTest.ApplicationSample.class})
public class TestProperties {

    @Autowired
    private SamplePropertiesTest.ApplicationSample.SamplePro samplePro;
    @Autowired
    private TestApplication.testProperties properties;

    @Test
    void test() {
        Assertions.assertEquals("Learn SpringBoot Test", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
    }

    @Test
    void testsample() {
        Assertions.assertEquals("Learn SpringBoot", samplePro.getName());
        Assertions.assertEquals(1, samplePro.getVersion());
    }

    @SpringBootApplication
    @PropertySources({
            @PropertySource("classpath:/sample.properties")
    })
    public static class TestApplication{

        @Getter
        @Component
        public static class testProperties{

            @Value("${test.name}")
            private String name;
            @Value("${test.version}")
            private Integer version;
        }

    }
}
