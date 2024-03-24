package hasanalmunawarDev.springConfigProperties.messagesource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class MeesageSourceTest {
    
    private ApplicationContext context;
    
    private MessageSource messageSource;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigReactiveWebApplicationContext(TestApplicaton.class);
        messageSource = context.getBean(MessageSource.class);
    }

    @Test
    void testDefault() {
        String message = messageSource.getMessage("hello", new Object[]{"hasan"}, Locale.ENGLISH);
        Assertions.assertEquals("hello hasan", message);
    }

    @Test
    void testIndonesian() {
        String message = messageSource.getMessage("hello", new Object[]{"hasan"}, new Locale("id"));
        Assertions.assertEquals("hello hasan", message);
    }

    @SpringBootApplication
    public static class TestApplicaton{

        @Bean
        public MessageSource messageSource(){
            ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
            messageSource.setBasenames("my");
            return  messageSource;
        }
    }
}
