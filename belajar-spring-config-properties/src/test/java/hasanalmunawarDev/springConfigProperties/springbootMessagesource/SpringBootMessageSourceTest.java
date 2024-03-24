package hasanalmunawarDev.springConfigProperties.springbootMessagesource;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootTest(classes = SpringBootMessageSourceTest.TestApplication.class)
public class SpringBootMessageSourceTest {

    @Autowired
    private TestApplication.SampleSource sampleSource;

    @Test
    void testHelloEko() {
        Assertions.assertEquals("Hello Hasan", sampleSource.sayHello(Locale.ENGLISH));
        Assertions.assertEquals("Halo Hasan", sampleSource.sayHello(new Locale("id", "ID")));
    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        public static class SampleSource implements MessageSourceAware {

            @Setter
            private MessageSource messageSource;

            public String sayHello(Locale locale) {
                return messageSource.getMessage("hello", new Object[]{"Hasan"}, locale);
            }

        }

    }

}
