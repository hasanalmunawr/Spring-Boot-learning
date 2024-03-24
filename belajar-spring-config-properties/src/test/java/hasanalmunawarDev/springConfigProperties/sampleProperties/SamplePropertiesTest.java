package hasanalmunawarDev.springConfigProperties.sampleProperties;

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

@SpringBootTest(classes = SamplePropertiesTest.ApplicationSample.class)
public class SamplePropertiesTest {

    @Autowired
    private ApplicationSample.SamplePro samplePro;

    @Test
    void testsample() {
        Assertions.assertEquals("Learn SpringBoot", samplePro.getName());
        Assertions.assertEquals(1, samplePro.getVersion());
    }


    @SpringBootApplication
    @PropertySources({
            @PropertySource("classpath:/sample.properties")
    })
    public static class ApplicationSample {

        @Component
        @Getter
        public static class SamplePro {

            @Value("${sample.name}")
            private String name;

            @Value("${sample.version}")
            private Integer version;
        }
    }
}
